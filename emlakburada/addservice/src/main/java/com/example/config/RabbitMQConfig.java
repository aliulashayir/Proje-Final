package com.example.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange adExchange() {
        return new TopicExchange("adExchange");
    }

    @Bean
    public Queue adQueue() {
        return new Queue("adQueue");
    }

    @Bean
    public Queue userQueue() {
        return new Queue("userQueue");
    }

    @Bean
    public Queue paymentQueue() {
        return new Queue("paymentQueue");
    }
}
