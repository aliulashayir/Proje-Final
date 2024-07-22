package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PackageResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private LocalDate validityPeriod;
}
