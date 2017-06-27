package com.sun.base;

import java.util.List;

public interface BaseDaoI<T> {
	public void save(T entity);
	public void delete(Long id);
	public void update(T entity);
	public T findById(Long id);
	public List<T> findByIds(Long[] ids);
	public List<T> findAll();
}
