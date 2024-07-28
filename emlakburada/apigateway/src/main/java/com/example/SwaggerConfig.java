package com.example;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userServiceApi() {
        return GroupedOpenApi.builder()
                .group("user-service")
                .pathsToMatch("/api/v1/users/**")
                .build();
    }

    @Bean
    public GroupedOpenApi adServiceApi() {
        return GroupedOpenApi.builder()
                .group("ad-service")
                .pathsToMatch("/api/v1/ads/**")
                .build();
    }

    @Bean
    public GroupedOpenApi packageServiceApi() {
        return GroupedOpenApi.builder()
                .group("package-service")
                .pathsToMatch("/api/v1/packages/**")
                .build();
    }

    @Bean
    public GroupedOpenApi reviewServiceApi() {
        return GroupedOpenApi.builder()
                .group("review-service")
                .pathsToMatch("/api/v1/reviews/**")
                .build();
    }

    @Bean
    public GroupedOpenApi paymentServiceApi() {
        return GroupedOpenApi.builder()
                .group("payment-service")
                .pathsToMatch("/api/v1/payments/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API Gateway")
                        .version("1.0")
                        .description("API Gateway for Microservices"));
    }
}
