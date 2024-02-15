package ru.gb.phonebook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.phonebook.service.AbonentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RestAbonentController {
    private final AbonentService service;

    @GetMapping("/list")
    public ResponseEntity<?> getAllAbonents() {
        return ResponseEntity.ok(service.findAll());
    }
}
