package com.example.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange packageExchange() {
        return new TopicExchange("packageExchange");
    }

    @Bean
    public Queue packageQueue() {
        return new Queue("packageQueue");
    }

    @Bean
    public Queue adQueue() {
        return new Queue("adQueue");
    }
}
