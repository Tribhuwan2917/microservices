package com.pal.user_microservics.UserMicroservicesAPIGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserMicroservicesApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroservicesApiGatewayApplication.class, args);
	}

}
//https://github.com/Netflix/eureka/wiki/Eureka-REST-operations(It will contains all urls of apis)
