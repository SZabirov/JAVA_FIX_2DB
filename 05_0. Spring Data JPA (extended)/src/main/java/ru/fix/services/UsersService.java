package ru.fix.services;

import ru.fix.models.User;
import ru.fix.repositories.UsersRepository;

import java.util.List;

public interface UsersService {
    List<User> getAll();
    User getById(Integer id);
    User getByUsername(String username);
    List<User> getUsersHavingAnyProducts();

    User getSomeUser();

    List<User> getAllUsersHavingProductsMoreThanLimit(Integer minCost);
    List<UsersRepository.UsersWithProductCounts> getAllUsersWithCountHavingProductsMoreThanLimit(Integer minCost);
}
