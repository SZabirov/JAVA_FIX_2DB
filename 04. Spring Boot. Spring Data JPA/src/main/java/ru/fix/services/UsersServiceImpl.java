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
//        User u1 = new User(1, "abc", "qwerty");
//        User u2 = new User(2, "qewr", "asdf");
//        List<User> users = new ArrayList<>();
//        users.add(u1);
//        users.add(u2);
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
}
