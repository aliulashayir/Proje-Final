package com.example.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange reviewExchange() {
        return new TopicExchange("reviewExchange");
    }

    @Bean
    public Queue reviewQueue() {
        return new Queue("reviewQueue");
    }

    @Bean
    public Queue adQueue() {
        return new Queue("adQueue");
    }
}
