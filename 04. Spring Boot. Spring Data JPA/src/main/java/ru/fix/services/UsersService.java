package ru.fix.services;

import ru.fix.models.User;

import java.util.List;

public interface UsersService {
    List<User> getAll();
    User getById(Integer id);
    User getByUsername(String username);
    List<User> getUsersHavingAnyProducts();
}
