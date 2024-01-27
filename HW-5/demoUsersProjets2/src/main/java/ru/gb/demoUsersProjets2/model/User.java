package ru.gb.demoUsersProjets2.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Сущность "Пользователь"
 */
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Имя пользователя.
     */
    private String username;
    /**
     * Пароль пользователя.
     */
    private String password;
    /**
     * Email пользователя.
     */
    private String email;
    /**
     * Роль пользователя.
     */
    private String role;
}
