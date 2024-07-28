package com.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
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
        return new Queue("packageQueue", true);
    }

    @Bean
    public Binding packageBinding(Queue packageQueue, TopicExchange packageExchange) {
        return BindingBuilder.bind(packageQueue).to(packageExchange).with("package.created");
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public MessageListenerAdapter packageListenerAdapter(PackageReceiver packageReceiver) {
        return new MessageListenerAdapter(packageReceiver, "receiveMessage");
    }

    @Bean
    public MessageListenerContainer packageContainer(ConnectionFactory connectionFactory, MessageListenerAdapter packageListenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("packageQueue");
        container.setMessageListener(packageListenerAdapter);
        return container;
    }
}
