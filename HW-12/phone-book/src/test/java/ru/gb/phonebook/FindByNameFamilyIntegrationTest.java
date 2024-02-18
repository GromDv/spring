package ru.gb.phonebook;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.gb.phonebook.domain.Abonent;
import ru.gb.phonebook.repository.JpaAbonentRepository;
import ru.gb.phonebook.service.AbonentService;

import java.util.List;

/**
 * Интеграционный тест боевого репозитория и сервиса
 */
@SpringBootTest
public class FindByNameFamilyIntegrationTest {
    @Autowired
    private JpaAbonentRepository repository;
    @Autowired
    private AbonentService service;

    /**
     * Тест поиска абонента по имени и фамилии
     * Должен найти существующий объект
     */
    @ParameterizedTest
    @CsvSource({"Вася, Петров", "Коля, Сидоров"})
    public void findAbonentTest(String fName, String lName) {
        List<Abonent> tList = service.findByFLName(repository.findAll(), fName, lName);

        assert !tList.isEmpty();
        assert tList.size() == 1;
        assert tList.get(0).getFirstName().equals(fName);
    }

    /**
     * Тест поиска абонента по имени и фамилии
     * Не должен найти не существующий объект
     */
    @ParameterizedTest
    @CsvSource({"Коля, Петров"})
    public void findNotAbonentTest(String fName, String lName) {

        List<Abonent> tList = service.findByFLName(repository.findAll(), fName, lName);

        assert tList.isEmpty();
    }

}
