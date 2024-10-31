package com.project.gatewayservice.configuration;

import com.project.gatewayservice.security.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Autowired
    AuthenticationFilter authenticationFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("main-service-route", r -> r.path("/books/**")
                        .filters(f -> f.filter(authenticationFilter))
                        .uri("lb://main-service"))
                .route("auth-additional-route", r -> r.path("/records/**")
                        .filters(f -> f.filter(authenticationFilter))
                        .uri("lb://additional-service"))
                .route("auth-service-route", r -> r.path("/auth/**")
                        .filters(f -> f.filter(authenticationFilter))
                        .uri("lb://auth-service"))
                .build();
    }
}