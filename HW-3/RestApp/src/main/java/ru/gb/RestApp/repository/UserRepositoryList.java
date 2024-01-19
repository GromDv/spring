package ru.gb.RestApp.repository;

import org.springframework.stereotype.Repository;
import ru.gb.RestApp.domain.User;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryList implements UniRepository {
    /**
     * Простой репозиторий в виде списка
     */
    private List<User> users = new ArrayList<>();

    /**
     * Получение списка пользователей
     * @return Список
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * добавление существующего пользователя в список
     * @param user
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Добавление несуществующего пользователя в список из параметров
     * @param name
     * @param age
     * @param email
     */
    public void addUser(String name, int age, String email) {
        users.add(new User(name, age, email));
    }

}
