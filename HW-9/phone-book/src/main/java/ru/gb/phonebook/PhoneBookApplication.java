package ru.gb.phonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Приложение "Телефонный справочник" (Spring DEMO)
 * Главная страница - localhost:8080/pb
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class PhoneBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneBookApplication.class, args);
    }

}
