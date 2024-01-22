package ru.gb.CRUD2.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.CRUD2.model.User;
import ru.gb.CRUD2.service.UserService;

import java.util.logging.Level;

@Controller
@AllArgsConstructor
@Log
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        log.log(Level.INFO,"Получен запрос '/users'");
        model.addAttribute("users", userService.findAll());
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        log.log(Level.INFO,"Получен запрос '/user-create'");
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        log.log(Level.INFO,"Получены данные для создания:" + user.toString());
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
        log.log(Level.INFO,"Получен запрос '/user-delete' user_id: " + id);
        userService.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping("/user-update")
    public String updateUserForm(Model model, @RequestParam("num") int id){
        log.log(Level.INFO,"Получен запрос '/user-update' user_id: " + id);
        model.addAttribute("user", userService.getUserById(id));
        log.log(Level.INFO,"Обновляем пользователя: " + userService.getUserById(id).toString());
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        log.log(Level.INFO,"Получены данные для обновления: " + user.toString());
        userService.updateUser(user);
        return "redirect:/users";
    }
}
