package ru.fix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fix.models.tables.records.ShopUserRecord;
import ru.fix.repositories.UsersRepository;
import ru.fix.transfer.UserDto;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<UserDto> getAll() {
        List<ShopUserRecord> shopUserRecords =
                usersRepository.findAll();
        return UserDto.from(shopUserRecords);
    }

    @Override
    public UserDto getById(Integer id) {
        Optional<ShopUserRecord> optionalShopUserRecord
                = usersRepository.findById(id);
        if (optionalShopUserRecord.isPresent()) {
            return UserDto.from(optionalShopUserRecord.get());
        }
        else {
            throw new IllegalArgumentException(
                    "No user with id = " + id + " found");
        }
    }

    @Override
    public UserDto getByUsername(String username) {
        return null;
//        Optional<User> optionalUser =
//                usersRepository.findOneByUsername(username);
//        if (optionalUser.isPresent()) {
//            return optionalUser.get();
//        }
//        else {
//            throw new IllegalArgumentException(
//                    "No user with username = " + username + " found");
//        }
    }

    @Override
    public List<UserDto> getUsersHavingAnyProducts() {
        return null;
//        return usersRepository.findUsersWithProducts();
    }
}
