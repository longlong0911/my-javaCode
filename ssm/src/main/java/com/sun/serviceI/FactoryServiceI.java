package com.sun.serviceI;

import java.util.List;

import com.sun.entity.Factory;

public interface FactoryServiceI{
	public Factory findById(String id);
	public List<Factory> findAll();
	public void addFactory(Factory factory);
	public void deleteById(String id);
	public void deleteByIds(String[] ids);
	public void updateFactory(Factory factory);
	public void closeFactory(Factory factory);
	public void openFactory(Factory factory);
}
