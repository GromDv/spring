package ru.gb.RestApp.services;

import ru.gb.RestApp.domain.User;
import ru.gb.RestApp.repository.UniRepository;
import ru.gb.RestApp.repository.UserRepositoryH2;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    private final UniRepository repository;

    /**
     * Метод внедряет зависимость через конструктор и подключает репозиторий нужного типа.
     *
     * @param repository - если указываем тип UserRepositoryH2, то используется репозиторий в БД Н2,
     *                   что проверяется через консоль БД: http://localhost:8080/h2-console.
     *                   Если укажем тип UserRepositoryList, будет использоваться List<Users>.
     */
    public DataProcessingService(UserRepositoryH2 repository) {
        this.repository = repository;
    }

    public UniRepository getRepository() {
        return repository;
    }

    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> sortUsersByAgeDesc(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge).reversed())
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
}
