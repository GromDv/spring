package ru.gb.demoUsersProjets2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Сущность "Проект"
 */
@Data
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Имя проекта.
     */
    private String name;
    /**
     * Описание проекта.
     */
    private String description;
    /**
     * Дата создания.
     */
    private LocalDateTime createdDate;
}
