package com.example.controller;

import com.example.dto.ReviewRequestDTO;
import com.example.dto.ReviewResponseDTO;
import com.example.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/{adId}/review")
    public ResponseEntity<ReviewResponseDTO> reviewAd(@PathVariable Long adId, @RequestBody ReviewRequestDTO reviewRequestDTO) {
        log.info("Received review request for ad ID: {}", adId);
        ReviewResponseDTO reviewResponseDTO = reviewService.reviewAd(adId, reviewRequestDTO);
        return new ResponseEntity<>(reviewResponseDTO, HttpStatus.OK);
    }
}
