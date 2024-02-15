package ru.gb.phonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Приложение "Телефонный справочник" (Spring DEMO)
 * Главная страница - localhost:8080/pb
 */
@SpringBootApplication
public class PhoneBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneBookApplication.class, args);
    }

}
