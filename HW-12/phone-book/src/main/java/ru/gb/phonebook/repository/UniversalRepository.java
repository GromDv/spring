package ru.gb.phonebook.repository;

import java.util.List;
import java.util.Optional;

import ru.gb.phonebook.domain.Abonent;

/**
 * Интерфейс универсального репозитория для телефонного справочника
 */
public interface UniversalRepository {
    /**
     * Возвращает список всех абонентов
     *
     * @return
     */
    public List<Abonent> findAll();

    /**
     * Добавляет нового абонента как сущность
     *
     * @param
     */
    void save(Abonent abonent);

    /**
     * Удаляет абонента по id
     */
    public void delete(Abonent a);

    /**
     * Возвращает абонента по id
     *
     * @param id
     * @return
     */
    Optional<Abonent> findById(Long id);

    /**
     * Обновляет абонента по id
     *
     * @param abonent
     */
    public void update(Abonent abonent);
}
