package com.wirtz.ecommerce.modelutil.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

public class GenericDaoHibernate<E, PK extends Serializable> implements GenericDao<E, PK> {

	//++19
	@Autowired
	private SessionFactory sessionFactory;
	private Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public GenericDaoHibernate() {
		this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void create(E entity) {
		getSession().persist(entity);
	}

	public boolean exists(PK id) {
		E entity = getSession().get(entityClass, id);
		return entity != null;
	}

	public E find(PK id) throws InstanceNotFoundException {

		E entity = (E) getSession().get(entityClass, id);

		if (entity == null) {
			throw new InstanceNotFoundException(id, entityClass.getName());
		}

		return entity;

	}

	public void remove(PK id) throws InstanceNotFoundException {
		getSession().delete(find(id));
	}

	@SuppressWarnings("unchecked")
	public E update(E entity) {
		return (E) getSession().merge(entity);
	}

}
