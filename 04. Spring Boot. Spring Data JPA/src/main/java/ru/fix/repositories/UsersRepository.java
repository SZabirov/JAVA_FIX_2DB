package ru.fix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.fix.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository
        extends JpaRepository<User, Integer> {
    Optional<User> findOneByUsername(String username);

    //запрос на jpql, который возвращает тех пользователей, у которых есть хоть один продукт
    @Query("SELECT u FROM User u WHERE size(u.products) > 0")
    List<User> findUsersWithProducts();
}
