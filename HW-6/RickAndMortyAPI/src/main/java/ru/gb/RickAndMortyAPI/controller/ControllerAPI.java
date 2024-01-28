package ru.gb.RickAndMortyAPI.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.RickAndMortyAPI.domain.Characters;
import ru.gb.RickAndMortyAPI.domain.Result;
import ru.gb.RickAndMortyAPI.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    /**
     * Получение объектов в виде списка JSON
     * @return
     */
    @GetMapping("")
    public ResponseEntity<Characters> getCharacters()
    {
        Characters allCharacters = serviceApi.getAllCharacters();
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }

    /**
     * Получение одного объекта в JSON
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public  ResponseEntity<Result> getCharacter(@PathVariable Long id) {
        Result person = serviceApi.getCharacter(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
