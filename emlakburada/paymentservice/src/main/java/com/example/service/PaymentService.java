package com.example.service;

import com.example.dto.PaymentRequestDTO;
import com.example.dto.PaymentResponseDTO;
import com.example.exception.PaymentNotFoundException;
import com.example.model.Payment;
import com.example.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final RabbitTemplate rabbitTemplate;

    @Value("${emlakburada.exchange}")
    private String exchange;

    @Value("${emlakburada.routingkey}")
    private String routingKey;

    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = Payment.builder()
                .userId(paymentRequestDTO.getUserId())
                .packageId(paymentRequestDTO.getPackageId())
                .amount(paymentRequestDTO.getAmount())
                .status("PENDING")
                .transactionId(generateTransactionId())
                .adId(paymentRequestDTO.getAdId())
                .build();
        Payment savedPayment = paymentRepository.save(payment);
        savedPayment.setStatus("COMPLETED");
        paymentRepository.save(savedPayment);
        sendPaymentMessage(savedPayment);
        return mapToResponseDTO(savedPayment);
    }

    public PaymentResponseDTO getPaymentDetails(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new PaymentNotFoundException("Payment not found with ID: " + id));
        return mapToResponseDTO(payment);
    }

    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    private void sendPaymentMessage(Payment payment) {
        rabbitTemplate.convertAndSend(exchange, routingKey, payment);
    }

    private PaymentResponseDTO mapToResponseDTO(Payment payment) {
        return PaymentResponseDTO.builder()
                .id(payment.getId())
                .userId(payment.getUserId())
                .packageId(payment.getPackageId())
                .amount(payment.getAmount())
                .status(payment.getStatus())
                .transactionId(payment.getTransactionId())
                .adId(payment.getAdId())
                .build();
    }
}
