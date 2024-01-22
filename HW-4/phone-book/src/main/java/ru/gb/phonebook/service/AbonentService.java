package ru.gb.phonebook.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.gb.phonebook.domain.Abonent;
import ru.gb.phonebook.repository.UniRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис работы с абонентами
 */
@Service
@AllArgsConstructor
@Getter
public class AbonentService {

    private final UniRepository repo;

    /**
     * Получение списка абонентов
     *
     * @return
     */
    public List<Abonent> findAll() {
        return repo.getPhoneBook();
    }

    /**
     * Добавление абонента
     *
     * @param abonent
     */
    public void addAbonent(Abonent abonent) {
        repo.add(abonent);
    }

    /**
     * Обновление абонента
     *
     * @param abonent
     */
    public void updateAbonent(Abonent abonent) {
        repo.update(abonent);
    }

    /**
     * Поиск абонента по имени и фамилии
     *
     * @param pb
     * @param fName
     * @param lName
     * @return
     */
    public List<Abonent> findByFLName(List<Abonent> pb, String fName, String lName) {
        return pb.stream()
                .filter(x -> x.getFirstName().equals(fName))
                .filter(x -> x.getLastName().equals(lName))
                .collect(Collectors.toList());
    }

    /**
     * Поиск абонента по id
     *
     * @param id
     * @return
     */
    public Abonent findById(int id) {
        return repo.findById(id);
    }

    /**
     * Удаление абонента по id
     *
     * @param id
     */
    public void removeAbonent(int id) {
        repo.remove(id);
    }
}
