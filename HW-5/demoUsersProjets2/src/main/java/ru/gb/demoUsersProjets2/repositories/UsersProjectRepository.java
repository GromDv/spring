package ru.gb.demoUsersProjets2.repositories;

import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLSelect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.gb.demoUsersProjets2.model.User;
import ru.gb.demoUsersProjets2.model.UsersProject;

import java.util.Collection;
import java.util.List;

/**
 * Репозиторий сущности Проекты-пользователи
 */
@Repository
public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
    /**
     * Найти всех пользователей проекта
     * @param projectId
     * @return
     */
    List<UsersProject> findAllByProjectId(Long projectId);

    /**
     * Найти все проекты пользователя
     * @param userId
     * @return
     */
    List<UsersProject> findAllByUserId(Long userId);

    /**
     * Найти записи по ID пользователя и ID проекта
     * @param userId
     * @param projectId
     * @return
     */
    List<UsersProject> findAllByUserIdAndProjectId(Long userId, Long projectId);
}
