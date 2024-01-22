package ru.gb.CRUD2.repository;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.CRUD2.config.AppProperties;
import ru.gb.CRUD2.model.User;

import java.util.List;
import java.util.logging.Level;

/**
 * Класс репозитория в БД
 */
@Repository
@Log
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;
    @Autowired
    private final AppProperties properties;

    /**
     * Получение всех записей
     *
     * @return
     */
    public List<User> findAll() {
        String sql = properties.getSqlSelectAll();
        log.log(Level.INFO, "sqlSelectAll-template: " + sql);

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Добавление пользователя
     *
     * @param user
     * @return
     */
    public User addUser(User user) {
        String sql = properties.getSqlInsert();
        log.log(Level.INFO, "sqlInsert-template: " + sql);

        log.log(Level.INFO, "Сохраняется: " + user.toString());
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Удаление пользователя по id
     *
     * @param id
     */
    public void deleteById(int id) {
        String sql = properties.getSqlDelete();
        log.log(Level.INFO, "sqlDelete-template: " + sql);
        jdbc.update(sql, id);
    }

    /**
     * Получение пользователя по id
     *
     * @param id
     * @return
     */
    public User getById(int id) {
        String sql = properties.getSqlSelectById();
        log.log(Level.INFO, "sqlSelectById-template: " + sql);

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper, id).getFirst();
    }

    /**
     * Обновление пользователя
     *
     * @param u
     */
    public void update(User u) {
        String sql = properties.getSqlUpdate();
        log.log(Level.INFO, "sqlUpdate-template: " + sql);

        log.log(Level.INFO, "Обновляется на: " + u.toString());
        jdbc.update(sql, u.getFirstName(), u.getLastName(), u.getId());
    }
}
