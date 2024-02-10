package ru.gb.cloudMicroService1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CloudMicroService1Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudMicroService1Application.class, args);
	}

}
