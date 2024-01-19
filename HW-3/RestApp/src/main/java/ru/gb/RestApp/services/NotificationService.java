package ru.gb.RestApp.services;

import ru.gb.RestApp.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyUser(User user) {
        System.out.println("NOTIFY: A new user has been created: " + user.getName());
    }

    public void sendNotification(String s) {
        System.out.println("NOTIFY: " + s);
    }
}
