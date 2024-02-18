package ru.gb.phonebook.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.phonebook.domain.Abonent;
import ru.gb.phonebook.service.AbonentService;
import ru.gb.phonebook.service.FileGateway;

@Controller
@AllArgsConstructor
public class AbonentController {
    private AbonentService service;
    private final FileGateway fileGateway;
    private final Timer timer;
    private final Counter counter;

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
    @GetMapping("/abonent-create")
    public String createNewAbonentForm(Abonent abonent) {
        return "add-new";
    }

    /**
     * Обработка запроса на создание нового абонента
     *
     * @param abonent
     * @return
     */
    @PostMapping("/abonent-create")
    public String createAbonent(Abonent abonent) {
        timer.record(() ->service.addAbonent(abonent));
        counter.increment();
        // сохраним созданного абонента с помощью Spring Integration
        fileGateway.writeToFile(abonent.getLastName() + ".txt", abonent.toString());
        return "redirect:/pb";
    }

    /**
     * Удаление абонента
     *
     * @param id
     * @return
     */
    @GetMapping("/abonent-delete/{id}")
    public String removeAbonentById(@PathVariable Long id) {
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
    @GetMapping("/ab-update")
    public String getPhoneBook(Model model, @RequestParam Long id) {
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
    @PostMapping("/ab-update")
    public String getPhoneBook(Model model, Abonent abonent) {
        model.addAttribute("abonent", abonent);
        service.updateAbonent(abonent);
        return "redirect:/pb";
    }

}
