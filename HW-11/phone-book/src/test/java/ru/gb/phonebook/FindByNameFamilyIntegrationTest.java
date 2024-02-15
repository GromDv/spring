package ru.gb.phonebook;

import jakarta.inject.Inject;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.phonebook.domain.Abonent;
import ru.gb.phonebook.repository.AbonentJpaRepository;
import ru.gb.phonebook.repository.AbonentRepository;
import ru.gb.phonebook.service.AbonentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Интеграционный тест боевого репозитория и сервиса
 */
@SpringBootTest
public class FindByNameFamilyIntegrationTest {
    @Autowired
    private AbonentJpaRepository repository;
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
