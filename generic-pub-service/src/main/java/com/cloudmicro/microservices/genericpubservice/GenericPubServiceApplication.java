package com.cloudmicro.microservices.genericpubservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GenericPubServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenericPubServiceApplication.class, args);
	}

}
