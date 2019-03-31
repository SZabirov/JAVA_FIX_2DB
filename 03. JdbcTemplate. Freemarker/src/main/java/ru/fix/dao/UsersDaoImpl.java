package ru.fix.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.fix.dao.mappers.UserRowMapper;
import ru.fix.models.User;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersDaoImpl implements UsersDao{
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UsersDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public User save(User user) {
        String sqlQuery = "INSERT INTO " +
                "shop_user(username, password) " +
                "VALUES(:nickname, :password);";
        Map<String, Object> map = new HashMap<>();
        map.put("nickname", user.getUsername());
        map.put("password", user.getPassword());
        namedParameterJdbcTemplate.update(sqlQuery, map);
        return null;
    }

    private UserRowMapper userRowMapper = new UserRowMapper();

    @Override
    public User find(Integer id) {
        String sqlQuery = "SELECT * FROM shop_user " +
                "WHERE id = ?";
        Object[] params = {id};
        User user = jdbcTemplate.queryForObject(sqlQuery,
                params, userRowMapper);
        return user;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        String sqlQuery = "SELECT * FROM shop_user";
        List<User> users = jdbcTemplate.query(sqlQuery, userRowMapper);
        return users;
    }
}








