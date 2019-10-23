package service;

import java.util.List;

public interface Serviceable<T extends Object> {
    List<T> findAll();
    T findById(long id);
    boolean deleteById(long id);
    boolean delete(T entity);
    T create(T entity);
    T update(T entity);
}
