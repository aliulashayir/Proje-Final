package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageRequestDTO {
    private String name;
    private String description;
    private Double price;
    private Integer validityPeriod; // Validity period in days
}
