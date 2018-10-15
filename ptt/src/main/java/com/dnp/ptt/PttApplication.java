package com.dnp.ptt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PttApplication {

	public static void main(String[] args) {
		SpringApplication.run(PttApplication.class, args);
	}
}
