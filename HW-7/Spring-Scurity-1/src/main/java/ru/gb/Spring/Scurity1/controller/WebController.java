package ru.gb.Spring.Scurity1.controller;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebController {
    /**
     * Обработка запроса главной страницы
     * @return
     */
    @GetMapping("/")
    public String hello() {
        return "index.html";
    }

    /**
     * Страница пользователя
     * @return
     */
    @GetMapping("/public-data")
    public String user() {
        return "user.html";
    }

    /**
     * Страница админа
     * @return
     */
    @GetMapping("/private-data")
    public String admin() {
        return "admin.html";
    }

    /**
     * Страница авторизации
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "mylogin.html";
    }

    /**
     * Обработка запроса выхода
     * @return
     */
    @PostMapping("/logout")
    public String performLogout() {
        return "redirect:/";
    }

    /**
     * Обработка запроса запрещенного/отсутствующего ресурса
     * @return
     */
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "denied.html";
    }
}
