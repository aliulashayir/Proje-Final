package com.example.service;

import com.example.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserClientService {
    private final RestTemplate restTemplate;

    public UserDTO getUserById(Long userId) {
        String url = "http://user-service/api/v1/users/" + userId;
        return restTemplate.getForObject(url, UserDTO.class);
    }
}
