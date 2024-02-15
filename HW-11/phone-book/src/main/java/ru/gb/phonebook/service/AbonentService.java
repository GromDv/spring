package ru.gb.phonebook.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.gb.phonebook.aspects.TrackUserAction;
import ru.gb.phonebook.aspects.TrackWithTimingUserAction;
import ru.gb.phonebook.domain.Abonent;
import ru.gb.phonebook.repository.AbonentJpaRepository;
import ru.gb.phonebook.repository.UniRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Сервис работы с абонентами
 */
@Service
@AllArgsConstructor
@Getter
public class AbonentService {

    private final AbonentJpaRepository repo;

    /**
     * Получение списка абонентов
     *
     * @return
     */
    @TrackUserAction
    public List<Abonent> findAll() {
        return repo.findAll();
    }

    /**
     * Добавление абонента
     *
     * @param abonent
     */
    public void addAbonent(Abonent abonent) {
        repo.save(abonent);
    }

    /**
     * Обновление абонента
     *
     * @param abonent
     */
    @TrackWithTimingUserAction
    public void updateAbonent(Abonent abonent) {
        repo.save(abonent);
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
        Optional<Abonent> abonent = repo.findById(id);
        return abonent.orElse(null);
    }

    /**
     * Удаление абонента по id
     *
     * @param id
     */
    public void removeAbonent(Long id) {
        Abonent a = new Abonent();
        a = repo.findById(id).orElse(null);
        if (a != null)
            repo.delete(a);
    }
}
