package app.dao;

public interface CrudDao<T> {
    T create(T model);
    T read(Integer id);
    T update(T model);
    void delete(Integer id);
}
