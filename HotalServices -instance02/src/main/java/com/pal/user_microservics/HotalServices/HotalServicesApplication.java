package com.pal.user_microservics.HotalServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotalServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotalServicesApplication.class, args);
	}

}
