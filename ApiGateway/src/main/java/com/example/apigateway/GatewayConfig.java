package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	 RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("Address-MicroService",r -> r
						.path("/address/**").uri("http://localhost:8081"))
				.route("Employee-MicroService", r->r
						.path("/employee/**").uri("http://localhost:8082"))
				.build();
	}
}
