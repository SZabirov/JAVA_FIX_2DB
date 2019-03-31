package ru.fix.javacource.springexample.app.dao;

public interface CrudDao<T> {
    T create(T t);
    T find(Integer id);

}
