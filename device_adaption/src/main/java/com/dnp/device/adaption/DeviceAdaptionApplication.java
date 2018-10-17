package com.dnp.device.adaption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DeviceAdaptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceAdaptionApplication.class, args);
	}
}
