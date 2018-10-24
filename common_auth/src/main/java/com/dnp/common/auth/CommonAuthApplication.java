package com.dnp.common.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CommonAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonAuthApplication.class, args);
	}
}
