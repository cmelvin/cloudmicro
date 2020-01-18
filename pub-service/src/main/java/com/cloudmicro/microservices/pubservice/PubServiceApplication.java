package com.cloudmicro.microservices.pubservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("com.cloudmicro.microservices.pubservice")
@EnableDiscoveryClient
public class PubServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubServiceApplication.class, args);
	}

}
