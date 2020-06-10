package com.dnp.service.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommonZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonZuulApplication.class, args);
	}
}
