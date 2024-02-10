package ru.gb.phonebook.controller;

import feign.Feign;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.phonebook.aspects.TrackUserAction;
import ru.gb.phonebook.domain.Abonent;
import ru.gb.phonebook.service.AbonentService;
import ru.gb.phonebook.service.AbonentServiceFeign;

import java.util.List;

@RestController
@AllArgsConstructor
public class AbonentRestController {
    private AbonentService service;

    /**
     * Получение списка абонентов в JSON
     *
     * @return
     */
    @GetMapping("/pb/api")
    @TrackUserAction
    public ResponseEntity<List<Abonent>> getAllAbonentsFg() {
        return ResponseEntity.ok(service.findAll());
    }

}
