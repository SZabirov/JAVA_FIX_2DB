package ru.fix.repositories;


import ru.fix.models.tables.records.ShopUserRecord;

import java.util.List;
import java.util.Optional;

public interface UsersRepository {
    Optional<ShopUserRecord> findOneByUsername(String username);

    Optional<ShopUserRecord> findById(Integer id);

    List<ShopUserRecord> findUsersWithProducts();

    List<ShopUserRecord> findAll();
}
