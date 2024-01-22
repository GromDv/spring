package ru.gb.CRUD2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.CRUD2.model.User;
import ru.gb.CRUD2.repository.UserRepository;

import java.util.List;

/**
 * Сервис работы с пользователями
 */
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /**
     * Получить весь список
     *
     * @return
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Добавить пользователя
     *
     * @param user
     * @return
     */
    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    /**
     * Удалить пользователя
     *
     * @param id
     */
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    /**
     * Получить пользователя по id
     *
     * @param id
     * @return
     */
    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    /**
     * Обновить пользователя
     *
     * @param user
     */
    public void updateUser(User user) {
        userRepository.update(user);
    }
}
