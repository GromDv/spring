package ru.gb.RestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.gb.RestApp.domain.User;
import org.springframework.stereotype.Service;
import ru.gb.RestApp.repository.UserRepositoryList;

@Service
public class UserService {

    // @Autowired
    private NotificationService notificationService;

    // Внедрение зависимости через конструктор
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Autowired
    private UserRepositoryList repository;

    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);

        return user;
    }
}
