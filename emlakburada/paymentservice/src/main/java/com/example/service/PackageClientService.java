package com.example.service;

import com.example.dto.PackageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PackageClientService {
    private final RestTemplate restTemplate;

    public boolean existsById(Long packageId) {
        try {
            PackageDTO pkg = restTemplate.getForObject("http://package-service/api/v1/packages/" + packageId, PackageDTO.class);
            return pkg != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void updatePackageDetails(Long packageId) {
        restTemplate.put("http://package-service/api/v1/packages/" + packageId + "/update", null);
    }
}
