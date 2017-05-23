package dao;

import java.io.*;
import java.util.*;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class AbstractModel<T> {

	private Class<T> entityClass;

	protected HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public AbstractModel(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public AbstractModel() {
	}

	@Transactional
	public void create(T instance) {
		this.hibernateTemplate.save(instance);
	}

	@Transactional
	public void update(T instance) {
		this.hibernateTemplate.update(instance);
	}
	
	@Transactional
	public void saveOrUpdate(T instance) {
		this.hibernateTemplate.saveOrUpdate(instance);
	}

	@Transactional
	public void delete(T instance) {
		this.hibernateTemplate.delete(instance);
	}

	@Transactional(readOnly = true)
	public T findById(Object primarykey) {
		return (T) this.hibernateTemplate.get(entityClass, (Serializable) primarykey);
	}

	@Transactional(readOnly = true)
	public List<T> findAll() {
		return this.hibernateTemplate.loadAll(entityClass);
	}

}
