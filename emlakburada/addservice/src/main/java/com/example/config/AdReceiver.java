package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AdReceiver {

    private static final Logger logger = LoggerFactory.getLogger(AdReceiver.class);

    public void receiveMessage(String message) {
        logger.info("Received <" + message + ">");
    }
}
