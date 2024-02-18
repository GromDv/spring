package ru.gb.phonebook;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.phonebook.domain.Abonent;
import ru.gb.phonebook.repository.JpaAbonentRepository;
import ru.gb.phonebook.service.AbonentService;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindByNameFamilyServiceTest {
    /**
     * Будем имитировать работу репозитория Mock-объектом
     */
    @Mock
    private JpaAbonentRepository repository;
    /**
     * Инжектируем сервис
     */
    @InjectMocks
    private AbonentService service;

    /**
     * Тест сервиса поиска абонента по имени и фамилии
     */
    @Test
    public void findAbonentTest() {
        List<Abonent> phooneBook = new ArrayList<>();

        Abonent abonent1 = new Abonent();
        abonent1.setFirstName("abFistName1");
        abonent1.setLastName("abLastName1");
        abonent1.setPhone(123456789L);
        abonent1.setAddress("abAddress1");
        phooneBook.add(abonent1);

        Abonent abonent2 = new Abonent();
        abonent2.setFirstName("abFistName2");
        abonent2.setLastName("abLastName2");
        abonent2.setPhone(123456789L);
        abonent2.setAddress("abAddress2");
        phooneBook.add(abonent2);

        Abonent abonent3 = new Abonent();
        abonent3.setFirstName("abFistName3");
        abonent3.setLastName("abLastName3");
        abonent3.setPhone(123456789L);
        abonent3.setAddress("abAddress3");
        phooneBook.add(abonent3);

        given(repository.findAll()).willReturn(phooneBook);

        List<Abonent> tList = service.findByFLName(repository.findAll(), "abFistName2", "abLastName2");

        assert !tList.isEmpty();
        assert tList.size() == 1;
        assert tList.get(0).getFirstName().equals("abFistName2");
    }

}
