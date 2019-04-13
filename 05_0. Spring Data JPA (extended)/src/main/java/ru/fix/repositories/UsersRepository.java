package ru.fix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.fix.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository
        extends JpaRepository<User, Integer>, UsersRepositoryCustom {

    @Query("SELECT distinct u FROM User u, Product p WHERE " +
            "p MEMBER OF u.products AND p.cost > :minCost ")
    List<User> findUsersHavingProductsMoreThanLimit(@Param("minCost") Integer minCost);

    @Query("SELECT u as user, count(p) as count" +
            " FROM User u, Product p WHERE " +
            "p MEMBER OF u.products AND p.cost > :minCost " +
            "group by u")
    List<UsersWithProductCounts>findUsersWithProductCountHavingProductsMoreThanLimit(@Param("minCost") Integer minCost);


    interface UsersWithProductCounts {
        User getUser();
        Integer getCount();
    }

    Optional<User> findOneByUsername(String username);

    //запрос на jpql, который возвращает тех пользователей, у которых есть хоть один продукт
    @Query("SELECT u FROM User u WHERE size(u.products) > 0")
    List<User> findUsersWithProducts();
}
