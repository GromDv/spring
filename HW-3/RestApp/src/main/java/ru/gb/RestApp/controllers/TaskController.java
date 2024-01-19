package ru.gb.RestApp.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.RestApp.domain.User;
import ru.gb.RestApp.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    /**
     * Метод возвращает список доступных задач.
     *
     * @return
     */
    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("sort-desc");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Метод возврящает JSON - список, отсортированый по возрасту
     *
     * @return JSON - список
     */
    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Метод возврящает JSON - список, отсортированый по возрасту в обратном порядке
     *
     * @return JSON - список
     */
    @GetMapping("/sort-desc")
    public List<User> sortUsersByAgeDesc() {
        return service.sortUsersByAgeDesc(service.getRepository().getUsers());
    }

    /**
     * Метод возврящает JSON - список, отфильтрованый по возрасту (более @param)
     *
     * @param age - нижняя граница ограничения возраста
     * @return JSON - список
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    /**
     * Метод возврящает JSON "Средний возраст пользователей"
     *
     * @return JSON
     */
    @GetMapping("/calc")
    public String calculateAverageAge() {
        return String.format("{\"Average age\":%.2f}", service.calculateAverageAge(service.getRepository().getUsers()));
    }
}
