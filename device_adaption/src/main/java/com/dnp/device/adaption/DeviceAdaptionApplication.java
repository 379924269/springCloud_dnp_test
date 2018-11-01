package com.dnp.device.adaption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class DeviceAdaptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceAdaptionApplication.class, args);
	}
}
