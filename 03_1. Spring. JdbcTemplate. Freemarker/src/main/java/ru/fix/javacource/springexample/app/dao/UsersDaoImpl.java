package ru.fix.javacource.springexample.app.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.fix.javacource.springexample.app.models.User;

import javax.sql.DataSource;
import java.util.List;

public class UsersDaoImpl implements UsersDao {
    private JdbcTemplate jdbcTemplate;

    public UsersDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User create(User user) {
        return null;
    }

    private RowMapper<User> rowMapper = (rs, i) ->
            new User(rs.getInt("id"), rs.getString("username"),
                    rs.getString("password"));

    public User find(Integer id) {
        String sqlQuery = "SELECT * FROM shop_user " +
                "WHERE id = ?";
        Object[] params = {id};
//        List<User> users = jdbcTemplate.query(sqlQuery, params, rowMapper);
        User user = jdbcTemplate.queryForObject(sqlQuery, params, rowMapper);
        return user;
    }
}
