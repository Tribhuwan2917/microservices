package com.pal.user_microservics.ServicesRegistoryOfUserMicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServicesRegistoryOfUserMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesRegistoryOfUserMicroservicesApplication.class, args);
	}

}
