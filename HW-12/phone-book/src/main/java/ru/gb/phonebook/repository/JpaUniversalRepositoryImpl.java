package ru.gb.phonebook.repository;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.gb.phonebook.domain.Abonent;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
@AllArgsConstructor
public class JpaUniversalRepositoryImpl implements UniversalRepository {

    private final JpaAbonentRepository repository;
    @Override
    public List<Abonent> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Abonent abonent) {
        repository.save(abonent);
    }

    @Override
    public void delete(Abonent a) {
        repository.delete(a);
    }

    @Override
    public Optional<Abonent> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void update(Abonent abonent) {
        repository.save(abonent);
    }
}
