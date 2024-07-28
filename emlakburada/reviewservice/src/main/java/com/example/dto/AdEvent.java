    package com.example.dto;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class AdEvent {
        private Long adId;
        private Long userId;
        private String status;
    }
