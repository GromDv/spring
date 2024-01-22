package ru.gb.CRUD2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Crud2Application {

	public static void main(String[] args) {
		SpringApplication.run(Crud2Application.class, args);
	}

}
