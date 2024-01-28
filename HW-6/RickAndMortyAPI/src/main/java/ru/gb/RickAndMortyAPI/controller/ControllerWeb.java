package ru.gb.RickAndMortyAPI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.RickAndMortyAPI.domain.Result;
import ru.gb.RickAndMortyAPI.service.ServiceApiImpl;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ControllerWeb {
    private final ServiceApiImpl serviceApi;

    /**
     * Отображение главной страницы (список объектов)
     * @param model
     * @return
     */
    @GetMapping()
    public String getAllCharacters(Model model) {
        List<Result> allCharacters = serviceApi.getAllCharacters().getResults();
        model.addAttribute("list", allCharacters);
        return "index.html";
    }

    /**
     * Отображение страницы персонажа
     * @param model
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public  String getPerson(Model model, @PathVariable Long id) {
        Result person = serviceApi.getCharacter(id);
        model.addAttribute("person", person);
        return "person.html";
    }
}
