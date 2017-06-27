package com.sun.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import edu.emory.mathcs.backport.java.util.Collections;
@SuppressWarnings("unchecked")
@Transactional
public class BaseDaoIpl<T> implements BaseDaoI<T> {
	@Resource
	private SessionFactory sessionFactory;
	protected Class<T> clazz;
	
	protected BaseDaoIpl(){
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) pt.getActualTypeArguments()[0];  //实际类型参数
		
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	

	
	
	
	public void save(T entity) {
		this.getSession().save(entity);
	}

	public void delete(Long id) {
		 Object obj = this.getSession().get(clazz,id);
		this.getSession().delete(obj);
	}

	public void update(T entity) {
		this.getSession().update(entity);
	}

	public T findById(Long id) {
		if(id==null){
			return null;
		}
		return (T) this.getSession().get(clazz,id);
	}

	public List<T> findByIds(Long[] ids) {
		if(ids==null || ids.length==0){
			return Collections.emptyList();
		}
		return this.getSession()
				.createQuery("from "+clazz.getSimpleName()+" where id in(:ids)")
				.setParameterList("ids",ids).list();
	}

	public List<T> findAll() {
		return this.getSession().createQuery(
						"from "+clazz.getSimpleName()).list();
	}
}
