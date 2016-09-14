package com.hermes.core.service;

import com.hermes.core.exception.ServiceException;
import com.hermes.core.util.GenericEntityUtil;
import com.hermes.core.GenericEntity;
import com.hermes.core.dao.GenericEntityDao;

import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.List;

/**
 * @param <T> entity type
 */
public abstract class GenericEntityServiceImpl<K extends Serializable & Comparable<K>, E extends GenericEntity<K, ?>>
        implements GenericEntityService<K, E> {

    private Class<E> objectClass;

    private GenericEntityDao<K, E> genericDao;

    @SuppressWarnings("unchecked")
    public GenericEntityServiceImpl(GenericEntityDao<K, E> genericDao) {
        this.genericDao = genericDao;

        this.objectClass = (Class<E>) GenericEntityUtil.getGenericEntityClassFromComponentDefinition(getClass());
    }

    protected final Class<E> getObjectClass() {
        return objectClass;
    }

    public E getEntity(Class<? extends E> clazz, K id) {
        return genericDao.getEntity(clazz, id);
    }

    public E findById(K id) {
        return genericDao.getById(id);
    }

    protected <V> E getByField(SingularAttribute<? super E, V> fieldName, V fieldValue) {
        return genericDao.getByField(fieldName, fieldValue);
    }

    public void save(E entity) throws ServiceException {
        genericDao.save(entity);
    }

    public void create(E entity) throws ServiceException {
        createEntity(entity);
    }

    protected void createEntity(E entity) throws ServiceException {
        save(entity);
    }

    public final void update(E entity) throws ServiceException {
        updateEntity(entity);
    }

    protected void updateEntity(E entity) throws ServiceException {
        genericDao.update(entity);
    }

    public void delete(E entity) throws ServiceException {
        genericDao.delete(entity);
    }

    public void flush() {
        genericDao.flush();
    }

    public void clear() {
        genericDao.clear();
    }

    public E refresh(E entity) {
        return genericDao.refresh(entity);
    }

    public List<E> list() {
        return genericDao.list();
    }

    protected <V> List<E> listByField(SingularAttribute<? super E, V> fieldName, V fieldValue) {
        return genericDao.listByField(fieldName, fieldValue);
    }

    public Long count() {
        return genericDao.count();
    }

}