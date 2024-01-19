package ru.gb.RestApp.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.RestApp.domain.User;

import java.util.List;

@Repository
public class UserRepositoryH2 implements UniRepository {
    private final JdbcTemplate jdbc;

    public UserRepositoryH2(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Получение списка пользователей из БД
     *
     * @return
     */
    public List<User> getUsers() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User u = new User();
            u.setName(r.getString("userName"));
            u.setAge(r.getInt("userAge"));
            u.setEmail(r.getString("userEmail"));
            return u;
        };

        return jdbc.query(sql, userRowMapper);
    }

    /**
     * добавление существующего пользователя в БД как сущности
     *
     * @param user
     * @return
     */
    public void addUser(User user) {
        jdbc.update("INSERT INTO userTable VALUES (NULL, ?, ?, ?)", user.getName(), user.getAge(), user.getEmail());
    }

    /**
     * добавление несуществующего пользователя в БД из параметров
     *
     * @param name
     * @param age
     * @param email
     * @return
     */
    public void addUser(String name, int age, String email) {
        User user = new User(name, age, email);
        String sql = "INSERT INTO userTable VALUES (NULL, ?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }
}
