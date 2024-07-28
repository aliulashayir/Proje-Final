package com.example.config;

import com.example.dto.AdEvent;
import com.example.model.Review;
import com.example.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewReceiver {

    private final ReviewRepository reviewRepository;

    public void receiveMessage(AdEvent adEvent) {
        Review review = Review.builder()
                .adId(adEvent.getAdId())
                .status("IN_REVIEW")
                .reviewer("Admin")
                .build();
        reviewRepository.save(review);
    }
}
