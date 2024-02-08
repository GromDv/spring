package ru.gb.demoAOP.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.gb.demoAOP.aspects.LoggedExecution;
import ru.gb.demoAOP.domen.User;
import ru.gb.demoAOP.repository.UserRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepo;

    /**
     * Метод получения списка пользователей
     *
     * @return
     */
    @LoggedExecution
    public List<User> showUsers() {
        return userRepo.findAll();
    }
}
