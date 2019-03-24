package app.dao;

import java.sql.*;
import app.models.User;

public class UserDaoImpl implements UserDao {
    private Connection connection;

    public UserDaoImpl(String url) {

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public User create(User user) {
        try {
            String sqlQuery = "INSERT INTO shop_user(username, password) " +
                    "VALUES (?, ?) RETURNING id;";
            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Integer id = rs.getInt("id");
            user.setId(id);
            return user;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public User read(Integer id) {
        try {
            String sqlQuery = "SELECT * FROM shop_user WHERE id = ?;";
            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return new User(id, rs.getString("username"), rs.getString("password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public User update(User model) {
        return null;
    }

    public void delete(Integer id) {

    }

    public User findByUsername(String username) {
        try {
            String sqlQuery = "SELECT * FROM shop_user WHERE username = ?;";
            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }    }
}
