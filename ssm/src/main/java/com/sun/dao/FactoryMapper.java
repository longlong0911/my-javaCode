package com.sun.dao;

import java.util.List;

import com.sun.entity.Factory;

public interface FactoryMapper {

    int deleteByPrimaryKey(String id);
    
    int insert(Factory record);

    int insertSelective(Factory record);

    Factory selectByPrimaryKey(String id);
    
    int updateByPrimaryKeySelective(Factory record);

    int updateByPrimaryKey(Factory record);

    List<Factory> getAll();
    public void delete(String[] ids);
}