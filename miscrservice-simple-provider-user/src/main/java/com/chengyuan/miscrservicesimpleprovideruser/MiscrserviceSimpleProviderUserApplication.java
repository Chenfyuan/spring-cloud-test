package com.chengyuan.miscrservicesimpleprovideruser;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MiscrserviceSimpleProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication application=new SpringApplication(MiscrserviceSimpleProviderUserApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}
