package org.example.eetest04.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.example.eetest04.model.Base;
import org.example.eetest04.utils.JpaProvider;

import java.util.List;
import java.util.Map;

public class CrudRepository<T extends Base, I> implements AutoCloseable {
    private EntityManager entityManager;

    public void save(T t) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(t);
        transaction.commit();
    }

    public void update(T t) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(t);
        transaction.commit();
    }


    public void delete(I id, Class<T> tClass) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        T entity = entityManager.find(tClass, id);
        entity.setDeleted(true);
        entityManager.merge(entity);
        transaction.commit();
    }

    public T findById(I id, Class<T> tClass) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        return entityManager.find(tClass, id);
    }

    public List<T> findAll( Class<T> tClass) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        Query query = entityManager.createQuery(String.format("select oo from %s oo where oo.deleted=false", tClass.getAnnotation(Entity.class).name()), tClass);
        return query.getResultList();
    }

    public List<T> findBy(String queryName, Map<String, Object> params, Class<T> tClass) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        Query query = entityManager.createNamedQuery(queryName, tClass);
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        return query.getResultList();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
