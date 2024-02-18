package ru.gb.phonebook.repository;

import lombok.Getter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.gb.phonebook.domain.Abonent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Класс репозитория в ArrayList (для простоты)
 */
@Getter
@Primary
@Repository
public class ListAbonentRepository implements UniversalRepository {
    private final List<Abonent> phoneBook = new ArrayList<>();

    /**
     * Конструктор с инициализацией некоторых абонентов
     */
    public ListAbonentRepository() {
        phoneBook.add(new Abonent(Abonent.getCounter(), "Петя", "Иванов", 9166841793L, "Тула"));
        phoneBook.add(new Abonent(Abonent.getCounter(), "Вася", "Петров", 9036548954L, "Москва"));
        phoneBook.add(new Abonent(Abonent.getCounter(), "Коля", "Сидоров", 9258692531L, "Тверь"));
    }

    public List<Abonent> findAll() {
        return phoneBook;
    }

    /**
     * Добавление абонента
     *
     * @param abonent
     */
    @Override
    public void save(Abonent abonent) {
        abonent.setId(Abonent.getCounter());
        phoneBook.add(abonent);
    }

    /**
     * Обновление абонента
     *
     * @param abonent
     */
    public void update(Abonent abonent) {
        Abonent n = new Abonent();
        n = phoneBook.stream().filter(x -> x.getId() == abonent.getId()).findFirst().orElse(null);
        if (n != null)
            phoneBook.set(phoneBook.indexOf(n), abonent);
    }

    /**
     * Удаление абонента по id
     *
     * @param id
     */
    @Override
    public void delete(Abonent a) {
        Abonent n = a;
        n = phoneBook.stream().filter(x -> x.getId() == a.getId()).findFirst().orElse(null);
        if (n != null)
            phoneBook.remove(n);
    }

    /**
     * Поиск абонента по id
     *
     * @param id
     * @return
     */
    @Override
    public Optional<Abonent> findById(Long id) {
        return phoneBook.stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }
}
