package com.project.gatewayservice.security;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AuthenticationFilterFactory extends AbstractGatewayFilterFactory {
//
//    @Override
//    public GatewayFilter apply(Object config) {
//        return (exchange, chain) -> chain.filter(exchange);
///*
//it works too
//       return new GatewayFilter() {
//           @Override
//           public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//               return chain.filter(exchange);
//           }
//       }
//*/
//    }
//
//}
public class AuthenticationFilterFactory{}