package ru.gb.RestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.RestApp.domain.User;

@Service
public class RegistrationService {

    @Autowired
    private DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private NotificationService notificationService;

    /**
     * Метод создаёт нового пользователя из параметров, добавляет в репозиторий и оповещает
     * об этом в консоли.
     *
     * @param name
     * @param age
     * @param email
     */
    public void processRegistrationList(String name, int age, String email) {
        User user = new User(name, age, email);
        dataProcessingService.getRepository().addUser(user);
        notificationService.notifyUser(user);
    }
}
