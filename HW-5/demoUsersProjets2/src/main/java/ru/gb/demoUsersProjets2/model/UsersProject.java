package ru.gb.demoUsersProjets2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Сущность "Пользователи-проекты" (кросс-таблица)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users_project")
public class UsersProject extends EntityWithRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "user_id")
    private Long userId;
}
