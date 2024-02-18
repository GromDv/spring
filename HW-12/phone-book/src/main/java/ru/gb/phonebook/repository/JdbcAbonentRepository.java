package ru.gb.phonebook.repository;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.phonebook.config.AppProperties;
import ru.gb.phonebook.domain.Abonent;
import java.util.logging.Level;

import java.util.List;
import java.util.Optional;

@Log
@Repository
@AllArgsConstructor
public class JdbcAbonentRepository  implements UniversalRepository{
    private final JdbcTemplate jdbc;
    /**
     * Подключаем properties с настройками SQL-скриптов
     */
    @Autowired
    private final AppProperties properties;

    /**
     * Метод выводит весь список
     * @return
     */
    @Override
    public List<Abonent> findAll() {
        String sql = properties.getSqlSelectAll();
        log.log(Level.INFO, "sql-template: " + sql);

        RowMapper<Abonent> userRowMapper = (r, i) -> {
            Abonent ab = new Abonent();
            ab.setId(r.getInt("id"));
            ab.setFirstName(r.getString("first_name"));
            ab.setLastName(r.getString("last_name"));
            ab.setPhone(r.getLong("phone"));
            ab.setAddress(r.getString("address"));
            return ab;
        };

        return jdbc.query(sql, userRowMapper);
    }

    @Override
    public void save(Abonent a) {
        String sql = properties.getSqlInsert();
        jdbc.update(sql, a.getFirstName(), a.getLastName(), a.getPhone(), a.getAddress());
    }

    /**
     * Метод удаляет абонента по id
     * @param id
     */
    @Override
    public void delete(Abonent a)  {
        String sql = properties.getSqlDelete();
        jdbc.update(sql, a.getId());
    }

    /**
     * Метод поиска абонента по id
     * @param id
     * @return
     */

    public Optional<Abonent> findById(Long id) {
        String sql = properties.getSqlSelectById();

        RowMapper<Abonent> userRowMapper = (r, i) -> {
            Abonent ab = new Abonent();
            ab.setId(r.getInt("id"));
            ab.setFirstName(r.getString("first_name"));
            ab.setLastName(r.getString("last_name"));
            ab.setPhone(r.getLong("phone"));
            ab.setAddress(r.getString("address"));
            return ab;
        };
        return Optional.ofNullable(jdbc.query(sql, userRowMapper, id).get(0));
    }

    /**
     * Метод обновляет абонента
     * @param u
     */
    @Override
    public void update(Abonent u) {
        String sql = properties.getSqlUpdate();
        jdbc.update(sql, u.getFirstName(), u.getLastName(), u.getPhone(), u.getAddress(), u.getId());
    }
}
