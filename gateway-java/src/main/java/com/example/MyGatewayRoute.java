package com.example;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyGatewayRoute {

	
	@Bean
	public RouteLocator getwayRounte(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->r.path("/api/**")
						.uri("http://localhost:8001"))
				.route(r->r.path("/product/**")
						.uri("http://localhost:8002"))
				.route(r->r.path("/cart/**")
						.uri("http://localhost:8003"))
				.route(r->r.path("/order/**")
						.uri("http://localhost:8004"))
				.build();
				
	}
}
