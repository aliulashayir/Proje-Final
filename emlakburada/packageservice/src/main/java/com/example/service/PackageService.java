package com.example.service;

import com.example.dto.AdEvent;
import com.example.dto.PackageRequestDTO;
import com.example.dto.PackageResponseDTO;
import com.example.model.Package;
import com.example.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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

    public PackageResponseDTO createPackage(PackageRequestDTO packageRequestDTO) {
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
        return packageRepository.findAll().stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    public PackageResponseDTO getPackageDetails(Long id) {
        Package pkg = packageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found"));
        return mapToResponseDTO(pkg);
    }

    public void deletePackage(Long id) {
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

    @RabbitListener(queues = "${emlakburada.queue}")
    public void handleAdCreated(AdEvent adEvent) {
        boolean isValid = checkPackageValidity(adEvent.getUserId());
        if (isValid) {
            processAd(adEvent);
        } else {
            rejectAd(adEvent);
        }
    }

    private void processAd(AdEvent adEvent) {
        log.info("Processing ad with id: {}", adEvent.getAdId());
        // Publish an event to RabbitMQ
        // ...
    }

    private void rejectAd(AdEvent adEvent) {
        log.warn("Ad with id {} rejected due to invalid package", adEvent.getAdId());
    }

    private boolean checkPackageValidity(Long userId) {
        Optional<Package> userPackage = packageRepository.findByUserId(userId);
        if (userPackage.isPresent()) {
            Package pkg = userPackage.get();
            return pkg.getValidityPeriod() != null && pkg.getValidityPeriod().isAfter(LocalDate.now());
        }
        return false;
    }
}
