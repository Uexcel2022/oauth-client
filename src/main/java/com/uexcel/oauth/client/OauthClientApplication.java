package com.uexcel.oauth.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class OauthClientApplication {

	@Bean
	RouteLocator gateWay(RouteLocatorBuilder rlb) {
		return rlb
				.routes()
				.route(rs -> rs
						.path("/home")
						.filters(GatewayFilterSpec::tokenRelay)
						.uri("http://localhost:9000"))
				.build();

	}


	public static void main(String[] args) {
		SpringApplication.run(OauthClientApplication.class, args);
	}



}
