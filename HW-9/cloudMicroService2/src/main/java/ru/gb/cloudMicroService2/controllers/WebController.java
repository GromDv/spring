package ru.gb.cloudMicroService2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/serviceB")
public class WebController {
    @GetMapping("/hi")
    public String hello(){
        return "Hello from Microservize-2";
    }

}