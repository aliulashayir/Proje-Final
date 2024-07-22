package com.example.service;

import com.example.dto.ReviewRequestDTO;
import com.example.dto.ReviewResponseDTO;
import com.example.exception.ReviewNotFoundException;
import com.example.model.Review;
import com.example.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @RabbitListener(queues = "adQueue")
    public void handleAdCreated(Long adId) {
        // Handle ad creation event, maybe create a review for the ad
    }

    public ReviewResponseDTO reviewAd(Long adId, ReviewRequestDTO reviewRequestDTO) {
        Review review = reviewRepository.findByAdId(adId)
                .orElseThrow(() -> new ReviewNotFoundException("Review not found for Ad ID: " + adId));
        review.setStatus(reviewRequestDTO.getStatus());
        review.setReviewer(reviewRequestDTO.getReviewer());
        Review updatedReview = reviewRepository.save(review);
        return mapToResponseDTO(updatedReview);
    }

    private ReviewResponseDTO mapToResponseDTO(Review review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .adId(review.getAdId())
                .status(review.getStatus())
                .reviewer(review.getReviewer())
                .build();
    }
}
