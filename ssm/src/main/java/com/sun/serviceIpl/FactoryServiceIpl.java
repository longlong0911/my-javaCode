package com.sun.serviceIpl;


import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.dao.FactoryMapper;
import com.sun.entity.Factory;
import com.sun.serviceI.FactoryServiceI;


@Service
@Transactional
public class FactoryServiceIpl implements FactoryServiceI{
	@Resource
	private FactoryMapper factoryMapper;
	
	@Override
	public Factory findById(String id) {
		return factoryMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<Factory> findAll() {
		return factoryMapper.getAll();
	}

	@Override
	public void addFactory(Factory factory) {
		factory.setId(UUID.randomUUID().toString());
		factory.setState(1); 
		factoryMapper.insert(factory);
	}
	@Override
	public void deleteById(String id) {
		factoryMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void deleteByIds(String[] ids) {
		factoryMapper.delete(ids);
	}
	@Override
	public void updateFactory(Factory factory) {
		factory.setState(1);
		factoryMapper.updateByPrimaryKey(factory);
		
	}
	
	@Override
	public void closeFactory(Factory factory) {
		factory.setState(0);
		factoryMapper.updateByPrimaryKey(factory);
	}
	@Override
	public void openFactory(Factory factory) {
		factory.setState(1);
		factoryMapper.updateByPrimaryKey(factory);
	}

}
