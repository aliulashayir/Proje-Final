package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentReceiver {

    private static final Logger logger = LoggerFactory.getLogger(PaymentReceiver.class);

    public void receiveMessage(String message) {
        logger.info("Received <" + message + ">");
    }
}
