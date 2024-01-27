package ru.gb.demoUsersProjets2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.demoUsersProjets2.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
