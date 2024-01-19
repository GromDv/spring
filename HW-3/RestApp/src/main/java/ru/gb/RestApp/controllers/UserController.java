package ru.gb.RestApp.controllers;

import ru.gb.RestApp.domain.User;
import ru.gb.RestApp.services.NotificationService;
import ru.gb.RestApp.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private RegistrationService service;
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    /**
     * Создание пользователя из JSON в теле POST-запроса
     *
     * @param user
     * @return
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getRepository().addUser(user);
        notificationService.notifyUser(user);
        return "User added from POST body!";
    }

    /**
     * Создание пользователя из парвметров GET-запроса: /body?&name=Ivan&age=32&email=test@ya.ru
     * Это не совсем корректно с точки зрения REST API, но возможно и интересно.
     *
     * @param name
     * @param age
     * @param email
     * @return
     */
    @GetMapping("/body")
    public String userAddFromParam(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("email") String email) {
        service.processRegistrationList(name, age, email);
        notificationService.sendNotification("User added from params!");
        return "User added from GET params!";
    }
}
