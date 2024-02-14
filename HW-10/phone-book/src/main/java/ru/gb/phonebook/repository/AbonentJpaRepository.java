package ru.gb.phonebook.repository;

import ru.gb.phonebook.domain.Abonent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonentJpaRepository extends JpaRepository<Abonent, Long> {
}
