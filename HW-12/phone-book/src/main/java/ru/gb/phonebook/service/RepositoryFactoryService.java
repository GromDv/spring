package ru.gb.phonebook.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.phonebook.config.AppProperties;
import ru.gb.phonebook.repository.JdbcAbonentRepository;
import ru.gb.phonebook.repository.JpaUniversalRepositoryImpl;
import ru.gb.phonebook.repository.ListAbonentRepository;
import ru.gb.phonebook.repository.UniversalRepository;

import java.util.logging.Level;

/**
 * Клавсс выбора типа репозитория реализует паттерн "Factory Method"
 */
@Component
@Log
@AllArgsConstructor
public class RepositoryFactoryService {

    @Autowired
    private final AppProperties properties;

    @Autowired
    private final JdbcAbonentRepository jdbcRepository;
    @Autowired
    private final ListAbonentRepository listRepository;
    @Autowired
    private final JpaUniversalRepositoryImpl jpaRepository;

    /**
     * Метод возвращает заданный в application.yaml репозиторий
     * @return
     */
    public UniversalRepository getActualReposytory() {
        log.log(Level.INFO, String.format("TYPE_REPO: %s", properties.getTypeRepo()));

        return switch (properties.getTypeRepo()) {
            case "jpa" -> jpaRepository;
            case "jdbc" -> jdbcRepository;
            case "list" -> listRepository;
            default -> listRepository;
        };
    }
}
