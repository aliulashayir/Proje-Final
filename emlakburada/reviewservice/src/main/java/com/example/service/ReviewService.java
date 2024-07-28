package com.example.service;

import com.example.dto.AdEvent;
import com.example.dto.ReviewRequestDTO;
import com.example.dto.ReviewResponseDTO;
import com.example.exception.ReviewNotFoundException;
import com.example.model.Review;
import com.example.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

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

    @RabbitListener(queues = "${emlakburada.queue}")
    public void handleAdCreated(AdEvent adEvent) {
        Review review = Review.builder()
                .adId(adEvent.getAdId())
                .status("IN_REVIEW")
                .reviewer("Admin")
                .build();
        reviewRepository.save(review);
    }
}
