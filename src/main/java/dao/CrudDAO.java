package dao;

import java.util.List;

public interface CrudDAO<T> {
    List<T> findAll();
    T findById(long id);
    boolean deleteById(long id);
    boolean delete(T entity);
    T create(T entity);
    T update(T entity);
}
