package ru.gb.phonebook.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Класс параметров конфигурации приложени
 */
@Log
@Data
@Configuration
@ConfigurationProperties(prefix = "pb")
public class AppProperties {
    /**
     * Текст SQL запроса "получить весь список"
     */
    private String sqlSelectAll;
    /**
     * Шаблон SQL запроса на вставку
     */
    private String sqlInsert;
    /**
     * Шаблон SQL запроса на удаление
     */
    private String sqlDelete;
    /**
     * Шаблон SQL запроса на обновление
     */
    private String sqlUpdate;
    /**
     * Шаблон SQL запроса на поиск по id
     */
    private String sqlSelectById;

    /**
     * Тип репозитория
     */
    private String typeRepo;
}