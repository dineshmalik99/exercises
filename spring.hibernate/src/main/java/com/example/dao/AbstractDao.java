package com.example.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao<T> {

		private final Class<T> persistentClass;

		@SuppressWarnings("unchecked")
		public AbstractDao() {
			this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	//    protected Criteria createEntityCriteria(){
	//        return getSession().createCriteria(persistentClass);
	//    }
	//    
	    @SuppressWarnings("unchecked")
		public T getByKey(long key) {
	        return (T) getSession().get(persistentClass, key);
	    }
	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
}
