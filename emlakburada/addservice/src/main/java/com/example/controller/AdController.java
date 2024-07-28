package com.example.controller;

import com.example.dto.AdRequestDTO;
import com.example.dto.AdResponseDTO;
import com.example.service.AdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ads")
@RequiredArgsConstructor
@Slf4j
public class AdController {
    private final AdService adService;

    @PostMapping
    public ResponseEntity<AdResponseDTO> createAd(@RequestBody AdRequestDTO adRequestDTO) {
        log.info("Received request to create ad: {}", adRequestDTO.getTitle());
        AdResponseDTO createdAd = adService.createAd(adRequestDTO);
        return ResponseEntity.ok(createdAd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdResponseDTO> updateAd(@PathVariable("id") Long id, @RequestBody AdRequestDTO adRequestDTO) {
        log.info("Received request to update ad with ID: {}", id);
        AdResponseDTO adResponseDTO = adService.updateAd(id, adRequestDTO);
        return new ResponseEntity<>(adResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdResponseDTO> getAdDetails(@PathVariable("id") Long id) {
        log.info("Received request to fetch ad by ID: {}", id);
        AdResponseDTO adResponseDTO = adService.getAdDetails(id);
        return new ResponseEntity<>(adResponseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AdResponseDTO>> listAllAds() {
        log.info("Received request to fetch all ads");
        List<AdResponseDTO> ads = adService.listAllAds();
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<List<AdResponseDTO>> listActiveAds() {
        log.info("Received request to fetch all active ads");
        List<AdResponseDTO> ads = adService.listActiveAds();
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @GetMapping("/passive")
    public ResponseEntity<List<AdResponseDTO>> listPassiveAds() {
        log.info("Received request to fetch all passive ads");
        List<AdResponseDTO> ads = adService.listPassiveAds();
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AdResponseDTO>> getUserAds(@PathVariable("userId") Long userId) {
        log.info("Received request to fetch ads for user with ID: {}", userId);
        List<AdResponseDTO> ads = adService.getUserAds(userId);
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable("id") Long id) {
        log.info("Received request to delete ad with ID: {}", id);
        adService.deleteAd(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
