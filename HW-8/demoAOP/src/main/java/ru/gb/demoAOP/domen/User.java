package ru.gb.demoAOP.domen;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Сущность "пользователь"
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
    /**
     * Кошелек пользователя
     */
    @Column(name = "pay_account")
    private BigDecimal payAccount;
}
