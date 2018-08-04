package cz.barasuchanova.persistence.dao;


import cz.barasuchanova.persistence.model.IEntity;

import java.util.Collection;

public interface IGenericDao<T extends IEntity> {
    void create(T entity) throws Exception;

    T read(Integer id) throws Exception;

    void update(T entity) throws Exception;

    void delete(T entity) throws Exception;

    Collection<T> getAll() throws Exception;

    boolean exists(T entity) throws Exception;

}