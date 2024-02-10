package ru.gb.phonebook.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.gb.phonebook.aspects.TrackUserAction;
import ru.gb.phonebook.clientdFeign.PhoneBookClientFeign;
import ru.gb.phonebook.domain.Abonent;

import java.util.List;

@Service
@AllArgsConstructor
public class AbonentServiceFeign {
    /**
     * Объект клиетнта Feign
     */
    private final PhoneBookClientFeign client;

    /**
     * Получение списка абонентов через клиент Feign
     *
     * @return
     */

    @TrackUserAction
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(client.getAllAbonents());
    }
}
