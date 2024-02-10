package ru.gb.phonebook.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.phonebook.domain.Abonent;
import ru.gb.phonebook.service.AbonentService;

import java.util.List;

@Controller
@AllArgsConstructor
public class AbonentController {
    private AbonentService service;

    /**
     * Обработка запроса главной страницы - вывод всего справочника
     *
     * @param model
     * @return
     */
    @GetMapping("/pb")
    public String getPhoneBook(Model model) {
        model.addAttribute("list", service.findAll());
        return "phone-book";
    }

    /**
     * Вывод страницы добавления нового абонента
     *
     * @param abonent
     * @return
     */
    @GetMapping("/pb/abonent-create")
    public String createNewAbonentForm(Abonent abonent) {
        return "add-new";
    }

    /**
     * Обработка запроса на создание нового абонента
     *
     * @param abonent
     * @return
     */
    @PostMapping("/pb/abonent-create")
    public String createAbonent(Abonent abonent) {
        service.addAbonent(abonent);
        return "redirect:/pb";
    }

    /**
     * Удаление абонента
     *
     * @param id
     * @return
     */
    @GetMapping("/pb/abonent-delete/{id}")
    public String removeAbonentById(@PathVariable int id) {
        service.removeAbonent(id);
        return "redirect:/pb";
    }

    /**
     * Вывод страницы редактирования абонента
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/pb/ab-update")
    public String getPhoneBook(Model model, @RequestParam int id) {
        model.addAttribute("abonent", service.findById(id));
        return "update";
    }

    /**
     * Обработка запроса на сохранение отредактированного абонента
     *
     * @param model
     * @param abonent
     * @return
     */
    @PostMapping("/pb/ab-update")
    public String getPhoneBook(Model model, Abonent abonent) {
        model.addAttribute("abonent", abonent);
        service.updateAbonent(abonent);
        return "redirect:/pb";
    }
}
