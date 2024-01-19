package ru.gb.RestApp.repository;

import ru.gb.RestApp.domain.User;

import java.util.List;

/**
 * Интерфейс универсального репозитория с нужными нам методами.
 */
public interface UniRepository {
    /**
     * Возвращает список всех пользователей
     *
     * @return
     */
    public List<User> getUsers();

    /**
     * Добавляет нового пользователя как сущность
     *
     * @param user
     */
    public void addUser(User user);

    /**
     * Добавляет нового пользователя из параметров
     *
     * @param name
     * @param age
     * @param email
     */
    public void addUser(String name, int age, String email);
}
