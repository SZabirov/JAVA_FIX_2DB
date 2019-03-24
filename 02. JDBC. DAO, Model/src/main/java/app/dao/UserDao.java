package app.dao;

import app.models.User;

public interface UserDao extends CrudDao<User> {
    User findByUsername(String username);
}
