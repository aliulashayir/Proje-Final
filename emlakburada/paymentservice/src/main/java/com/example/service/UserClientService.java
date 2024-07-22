package com.example.service;

import com.example.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserClientService {
    private final RestTemplate restTemplate;

    public boolean existsById(Long userId) {
        try {
            UserDTO user = restTemplate.getForObject("http://user-service/api/v1/users/" + userId, UserDTO.class);
            return user != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void updateBalance(Long userId, Double amount) {
        restTemplate.put("http://user-service/api/v1/users/" + userId + "/balance?amount=" + amount, null);
    }
}
