package ru.gb.cloudMicroService1.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/serviceA")
public class RestController {
    @GetMapping("/hi")
    public String hello(){
        return "Привет! Этот сервис полуил конфигурацию с гитхаба.\n";
    }

    @FeignClient("MicroFeign1")
    static interface NameService {
        @RequestMapping("/")
        public String getName();
    }

}
