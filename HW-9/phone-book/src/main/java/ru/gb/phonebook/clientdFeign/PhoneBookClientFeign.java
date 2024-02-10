package ru.gb.phonebook.clientdFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.phonebook.domain.Abonent;

import java.util.List;

/**
 * Интерфейс клиента Feign
 */

@FeignClient(name = "phoneBookMs", url = "http://localhost:8083/pb/list")
public interface PhoneBookClientFeign {
    @GetMapping
    ResponseEntity<List<Abonent>> getAllAbonents();
}
// почему-то ответ всегда такой: {"timestamp":"2024-02-10T13:21:11.954+00:00","status":404,"error":"Not Found","path":"/pb/list"}
