package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class MsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGatewayApplication.class, args);
	}

	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder){

		return builder.routes()
				.route("ms-auth", r->r.path("/api/auth/**").uri("lb://ms-auth")) //dynamic routing to auth-service
				.route("ms-auth", r->r.path("/api/test/**").uri("lb://ms-auth")) //dynamic routing to auth-service
				.route("ms-billing",r->r.path("/api/students/**").uri("lb://ms-billing"))
				.build();
	}

}
