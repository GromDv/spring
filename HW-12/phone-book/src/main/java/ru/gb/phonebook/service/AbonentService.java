package ru.gb.phonebook.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.phonebook.aspects.TrackUserAction;
import ru.gb.phonebook.aspects.TrackWithTimingUserAction;
import ru.gb.phonebook.domain.Abonent;
import ru.gb.phonebook.repository.UniversalRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Сервис работы с абонентами
 */
@Service
@Log
@Getter
@AllArgsConstructor
public class AbonentService {

 //   @Autowired
 //   private UniversalRepository repository;
    /**
     * Подключаем класс выбора типа репозитория
     */
    @Autowired
    private final RepositoryFactoryService factoryService;

    /**
     * Получение списка абонентов
     *
     * @return
     */
    @TrackUserAction
    public List<Abonent> findAll() {
        return factoryService.getActualReposytory().findAll();
    }

    /**
     * Добавление абонента
     *
     * @param abonent
     */
    public void addAbonent(Abonent abonent) {
        factoryService.getActualReposytory().save(abonent);
    }

    /**
     * Обновление абонента
     *
     * @param abonent
     */
    @TrackWithTimingUserAction
    public void updateAbonent(Abonent abonent) {
        factoryService.getActualReposytory().save(abonent);
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
    @TrackWithTimingUserAction
    public Abonent findById(Long id) {
        Optional<Abonent> abonent = factoryService.getActualReposytory().findById(id);
        return abonent.orElse(null);
    }

    /**
     * Удаление абонента по id
     *
     * @param id
     */
    public void removeAbonent(Long id) {
        Abonent a = new Abonent();
        a = factoryService.getActualReposytory().findById(id).orElse(null);
        if (a != null)
            factoryService.getActualReposytory().delete(a);
    }
}
