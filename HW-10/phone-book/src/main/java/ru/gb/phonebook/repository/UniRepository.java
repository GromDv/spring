package ru.gb.phonebook.repository;

import java.util.List;

import ru.gb.phonebook.domain.Abonent;

/**
 * Интерфейс репозитория для телефонного справочника
 */
public interface UniRepository {
    /**
     * Возвращает список всех абонентов
     *
     * @return
     */
    public List<Abonent> getPhoneBook();

    /**
     * Добавляет нового абонента как сущность
     *
     * @param
     */
    public void add(Abonent a);

    /**
     * Удаляет абонента по id
     *
     * @param id
     */
    public void remove(int id);

    /**
     * Возвращает абонента по id
     *
     * @param id
     * @return
     */
    public Abonent findById(int id);

    /**
     * Обновляет абонента по id
     *
     * @param abonent
     */
    public void update(Abonent abonent);

    void deleteAll();
}
