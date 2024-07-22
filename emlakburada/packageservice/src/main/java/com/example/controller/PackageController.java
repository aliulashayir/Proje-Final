package com.example.controller;

import com.example.dto.PackageRequestDTO;
import com.example.dto.PackageResponseDTO;
import com.example.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/packages")
@RequiredArgsConstructor
public class PackageController {
    private final PackageService packageService;

    @PostMapping
    public ResponseEntity<PackageResponseDTO> createPackage(@RequestBody PackageRequestDTO packageRequestDTO) {
        return ResponseEntity.ok(packageService.createPackage(packageRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PackageResponseDTO> updatePackage(@PathVariable Long id, @RequestBody PackageRequestDTO packageRequestDTO) {
        return ResponseEntity.ok(packageService.updatePackage(id, packageRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long id) {
        packageService.deletePackage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PackageResponseDTO>> listAllPackages() {
        return ResponseEntity.ok(packageService.listAllPackages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackageResponseDTO> getPackageDetails(@PathVariable Long id) {
        return ResponseEntity.ok(packageService.getPackageDetails(id));
    }
}
