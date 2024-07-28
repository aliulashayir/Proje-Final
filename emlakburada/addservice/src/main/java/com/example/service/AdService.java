package com.example.service;

import com.example.dto.AdEvent;
import com.example.dto.AdRequestDTO;
import com.example.dto.AdResponseDTO;
import com.example.dto.ReviewRequestDTO;
import com.example.exception.AdNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.model.Ad;
import com.example.model.Payment;
import com.example.model.User;
import com.example.repository.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdService {
    private final AdRepository adRepository;
    private final RestTemplate restTemplate;
    private final RabbitTemplate rabbitTemplate;

    public AdResponseDTO createAd(AdRequestDTO adRequestDTO) {
        if (!userExists(adRequestDTO.getUserId())) {
            throw new UserNotFoundException("User not found with ID: " + adRequestDTO.getUserId());
        }

        Ad ad = Ad.builder()
                .title(adRequestDTO.getTitle())
                .description(adRequestDTO.getDescription())
                .status("IN_REVIEW")
                .userId(adRequestDTO.getUserId())
                .build();
        Ad savedAd = adRepository.save(ad);
        sendReviewRequest(savedAd.getId());
        return mapToResponseDTO(savedAd);
    }

    private boolean userExists(Long userId) {
        try {
            restTemplate.getForObject("http://user-service/api/v1/users/" + userId, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public AdResponseDTO updateAd(Long id, AdRequestDTO adRequestDTO) {
        Ad ad = adRepository.findById(id).orElseThrow(() -> new AdNotFoundException("Ad not found with ID: " + id));
        ad.setTitle(adRequestDTO.getTitle());
        ad.setDescription(adRequestDTO.getDescription());
        ad.setStatus(adRequestDTO.getStatus());
        Ad updatedAd = adRepository.save(ad);
        return mapToResponseDTO(updatedAd);
    }

    public List<AdResponseDTO> listAllAds() {
        return adRepository.findAll().stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    public List<AdResponseDTO> listActiveAds() {
        return adRepository.findByStatus("ACTIVE").stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    public List<AdResponseDTO> listPassiveAds() {
        return adRepository.findByStatus("PASSIVE").stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    public AdResponseDTO getAdDetails(Long id) {
        Ad ad = adRepository.findById(id).orElseThrow(() -> new AdNotFoundException("Ad not found with ID: " + id));
        return mapToResponseDTO(ad);
    }

    public List<AdResponseDTO> getUserAds(Long userId) {
        return adRepository.findByUserId(userId).stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    public void deleteAd(Long id) {
        adRepository.deleteById(id);
    }

    public void reviewAd(Long adId, ReviewRequestDTO reviewRequestDTO) {
        Ad ad = adRepository.findById(adId).orElseThrow(() -> new AdNotFoundException("Ad not found with ID: " + adId));
        ad.setStatus(reviewRequestDTO.getStatus());
        adRepository.save(ad);
    }

    private void sendReviewRequest(Long adId) {
        AdEvent adEvent = new AdEvent();
        adEvent.setAdId(adId);
        adEvent.setStatus("IN_REVIEW");
        rabbitTemplate.convertAndSend("reviewExchange", "review.created", adEvent);
    }

    private AdResponseDTO mapToResponseDTO(Ad ad) {
        return AdResponseDTO.builder()
                .id(ad.getId())
                .title(ad.getTitle())
                .description(ad.getDescription())
                .status(ad.getStatus())
                .userId(ad.getUserId())
                .build();
    }

    // RabbitMQ message handlers
    public void handleUserUpdated(User user) {
        List<Ad> ads = adRepository.findByUserId(user.getId());
        ads.forEach(ad -> {
            ad.setUserId(user.getId());
            adRepository.save(ad);
        });
    }

    public void handlePaymentNotification(Payment payment) {
        Ad ad = adRepository.findById(payment.getAdId()).orElseThrow(() -> new AdNotFoundException("Ad not found with ID: " + payment.getAdId()));
        ad.setStatus("ACTIVE");
        adRepository.save(ad);
    }
}
