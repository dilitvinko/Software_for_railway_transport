package dao;

import entity.BaseEntity;

import java.util.List;

public interface CrudDAO<T extends BaseEntity> {
    List<T> findAll();
    T findById(long id);
    boolean deleteById(long id);
    boolean delete(T entity);
    T create(T entity);
    T update(T entity);
}
