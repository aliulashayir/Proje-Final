package com.example.service;

import com.example.dto.PackageRequestDTO;
import com.example.dto.PackageResponseDTO;
import com.example.model.Package;
import com.example.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PackageService {
    private final PackageRepository packageRepository;
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "adQueue")
    public void handleAdCreated(Long adId) {
        log.info("Received ad created message for ad id: {}", adId);
        // Add logic to handle ad creation notification if needed
    }

    private boolean checkPackageValidity(Long userId) {
        Optional<Package> userPackage = packageRepository.findByUserId(userId);
        if (userPackage.isPresent()) {
            Package pkg = userPackage.get();
            return pkg.getValidityPeriod() != null && pkg.getValidityPeriod().isAfter(LocalDate.now());
        }
        return false;
    }

    public PackageResponseDTO createPackage(PackageRequestDTO packageRequestDTO) {
        log.info("Creating new package: {}", packageRequestDTO.getName());
        Package pkg = Package.builder()
                .name(packageRequestDTO.getName())
                .description(packageRequestDTO.getDescription())
                .price(packageRequestDTO.getPrice())
                .validityPeriod(LocalDate.now().plusDays(packageRequestDTO.getValidityPeriod()))
                .build();
        Package savedPackage = packageRepository.save(pkg);
        return mapToResponseDTO(savedPackage);
    }

    public PackageResponseDTO updatePackage(Long id, PackageRequestDTO packageRequestDTO) {
        log.info("Updating package with ID: {}", id);
        Package pkg = packageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found"));
        pkg.setName(packageRequestDTO.getName());
        pkg.setDescription(packageRequestDTO.getDescription());
        pkg.setPrice(packageRequestDTO.getPrice());
        pkg.setValidityPeriod(LocalDate.now().plusDays(packageRequestDTO.getValidityPeriod()));
        Package updatedPackage = packageRepository.save(pkg);
        return mapToResponseDTO(updatedPackage);
    }

    public List<PackageResponseDTO> listAllPackages() {
        log.info("Listing all packages");
        return packageRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public PackageResponseDTO getPackageDetails(Long id) {
        log.info("Getting details for package with ID: {}", id);
        Package pkg = packageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found"));
        return mapToResponseDTO(pkg);
    }

    public void deletePackage(Long id) {
        log.info("Deleting package with ID: {}", id);
        packageRepository.deleteById(id);
    }

    private PackageResponseDTO mapToResponseDTO(Package pkg) {
        return new PackageResponseDTO(
                pkg.getId(),
                pkg.getName(),
                pkg.getDescription(),
                pkg.getPrice(),
                pkg.getValidityPeriod()
        );
    }
}
