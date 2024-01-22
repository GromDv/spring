package ru.gb.CRUD2.model;

import lombok.Data;

/**
 * Доменный класс пользователя создаем с аннотацией @Data для автоматического создания
 * геттеров, сеттеров, toString() equals()...
 */
@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
