package ru.fix.services;

import ru.fix.transfer.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAll();
    UserDto getById(Integer id);
    UserDto getByUsername(String username);
    List<UserDto> getUsersHavingAnyProducts();
}
