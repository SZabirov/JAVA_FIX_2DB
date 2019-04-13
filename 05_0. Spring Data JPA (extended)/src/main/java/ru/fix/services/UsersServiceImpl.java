package ru.fix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fix.models.User;
import ru.fix.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<User> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else {
            throw new IllegalArgumentException(
                    "No user with id = " + id + " found");
        }
    }

    @Override
    public User getByUsername(String username) {
        Optional<User> optionalUser =
                usersRepository.findOneByUsername(username);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else {
            throw new IllegalArgumentException(
                    "No user with username = " + username + " found");
        }
    }

    @Override
    public List<User> getUsersHavingAnyProducts() {
        return usersRepository.findUsersWithProducts();
    }

    @Override
    public User getSomeUser() {
        return usersRepository.findSomeUser();
    }

    @Override
    public List<User> getAllUsersHavingProductsMoreThanLimit(Integer minCost) {
        return usersRepository.findUsersHavingProductsMoreThanLimit(minCost);
    }

    @Override
    public List<UsersRepository.UsersWithProductCounts> getAllUsersWithCountHavingProductsMoreThanLimit(Integer minCost) {
        return usersRepository.findUsersWithProductCountHavingProductsMoreThanLimit(minCost);
    }
}
