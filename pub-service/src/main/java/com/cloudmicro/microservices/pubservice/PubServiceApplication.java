package com.cloudmicro.microservices.pubservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("com.cloudmicro.microservices.pubservice")
public class PubServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubServiceApplication.class, args);
	}

}
