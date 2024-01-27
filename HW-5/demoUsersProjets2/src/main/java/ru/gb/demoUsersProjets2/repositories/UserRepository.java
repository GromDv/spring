package ru.gb.demoUsersProjets2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.demoUsersProjets2.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
