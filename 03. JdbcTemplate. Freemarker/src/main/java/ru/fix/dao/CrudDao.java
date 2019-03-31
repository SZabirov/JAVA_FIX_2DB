package ru.fix.dao;

import java.util.List;

public interface CrudDao<T> {
    T save(T t);
    T find(Integer id);
    T update(T t);
    T delete(T t);
    List<T> findAll();
}
