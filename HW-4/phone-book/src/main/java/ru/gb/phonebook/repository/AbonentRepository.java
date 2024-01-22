package ru.gb.phonebook.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.gb.phonebook.domain.Abonent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс репозитория в ArrayList (для простоты)
 */
@Getter
@Repository
public class AbonentRepository implements UniRepository {
    private final List<Abonent> phoneBook = new ArrayList<>();

    /**
     * Конструктор с инициализацией некоторых абонентов
     */
    public AbonentRepository() {
        phoneBook.add(new Abonent(Abonent.getCounter(), "Петя", "Иванов", 9166841793L, "Тула"));
        phoneBook.add(new Abonent(Abonent.getCounter(), "Вася", "Петров", 9036548954L, "Москва"));
        phoneBook.add(new Abonent(Abonent.getCounter(), "Коля", "Сидоров", 9258692531L, "Тверь"));
    }

    /**
     * Добавление абонента
     *
     * @param a
     */
    public void add(Abonent a) {
        a.setId(Abonent.getCounter());
        phoneBook.add(a);
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
    public void remove(int id) {
        Abonent n = new Abonent();
        n = phoneBook.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (n != null)
            phoneBook.remove(n);
    }

    /**
     * Поиск абонента по id
     *
     * @param id
     * @return
     */
    public Abonent findById(int id) {
        return phoneBook.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
