package cz.barasuchanova.persistence.dao;


import cz.barasuchanova.exception.ResultNotFoundException;
import cz.barasuchanova.persistence.IEntityManagerProvider;
import cz.barasuchanova.persistence.model.IEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GenericDao<T extends IEntity> implements IGenericDao<T>, Serializable {

    protected IEntityManagerProvider entityManagerProvider;

    protected Class<T> persistentClass;

    public GenericDao(Class<T> persistentClass, IEntityManagerProvider entityManagerProvider) {
        this.persistentClass = persistentClass;
        this.entityManagerProvider = entityManagerProvider;
    }

    @Override
    public void create(T entity) throws Exception {
        EntityManager em = entityManagerProvider.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new Exception(e);
        } finally {
            em.close();
        }
    }

    @Override
    public T read(Integer id) throws Exception {
        return entityManagerProvider.getEntityManager().find(persistentClass, id);
    }

    @Override
    public void update(T entity) throws Exception {
        EntityManager em = entityManagerProvider.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(entity);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new Exception(e);
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(T entity) throws Exception {
        EntityManager em = entityManagerProvider.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new Exception(e);
        } finally {
            em.close();
        }
    }

    @Override
    public Collection<T> getAll() throws Exception {
        EntityManager em = entityManagerProvider.getEntityManager();
        CriteriaQuery q = em.getCriteriaBuilder().createQuery(persistentClass);
        Root<T> abstractRoot = q.from(persistentClass);
        q.select(abstractRoot);
        Collection<T> collection = em.createQuery(q).getResultList();
        return collection;
    }

    @Override
    public boolean exists(T entity) throws Exception {
        return entityManagerProvider.getEntityManager().find(persistentClass, entity.getId()) != null;
    }

}
