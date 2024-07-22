package com.example.repository;

import com.example.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {
    List<Ad> findByStatus(String status);
    List<Ad> findByUserId(Long userId);
}
