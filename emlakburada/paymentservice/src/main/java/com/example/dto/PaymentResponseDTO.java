package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDTO {
    private Long id;
    private Long userId;
    private Long packageId;
    private Double amount;
    private String status;
    private String transactionId;
    private Long adId;  // Add this field
}
