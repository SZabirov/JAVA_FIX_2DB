package ru.fix.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import ru.fix.models.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsersRepositoryCustomImpl implements UsersRepositoryCustom {
    @Autowired
    EntityManager em;

    @Override
    public User findSomeUser() {
        Query q = em
                .createQuery("SELECT u FROM User u WHERE id = :id");
        q.setParameter("id", 1);
        User u = (User) q.getSingleResult();
        return u;
    }
}
