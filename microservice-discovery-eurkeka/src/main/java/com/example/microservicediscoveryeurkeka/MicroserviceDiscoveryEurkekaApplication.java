package com.example.microservicediscoveryeurkeka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroserviceDiscoveryEurkekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDiscoveryEurkekaApplication.class, args);
	}
}
