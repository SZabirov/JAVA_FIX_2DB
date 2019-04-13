package ru.fix.repositories;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.fix.models.tables.records.ShopUserRecord;

import java.util.List;
import java.util.Optional;

import static ru.fix.models.tables.ShopUser.SHOP_USER;

@Component
public class UsersRepositoryJooqImpl implements UsersRepository {
    @Autowired
    DSLContext jooq;


    @Override
    public Optional<ShopUserRecord> findOneByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<ShopUserRecord> findById(Integer id) {
        ShopUserRecord shopUserRecord =
        jooq.selectFrom(SHOP_USER).where(SHOP_USER.ID.eq(id)).fetchOne();
        return Optional.ofNullable(shopUserRecord);
    }

    @Override
    public List<ShopUserRecord> findUsersWithProducts() {
        return null;
    }

    @Override
    public List<ShopUserRecord> findAll() {
        return jooq.selectFrom(SHOP_USER).fetch();
    }
}
