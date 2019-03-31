package ru.fix.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.fix.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User u = new User();
        u.setId(resultSet.getInt("id"));
        u.setUsername(resultSet.getString("username"));
        u.setPassword(resultSet.getString("password"));
        return u;
    }
}
