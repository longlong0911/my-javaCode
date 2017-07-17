package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.Export;

public interface ExportMapper {
    int deleteByPrimaryKey(String exportId);

    int insert(Export record);

    int insertSelective(Export record);

    Export selectByPrimaryKey(String exportId);

    int update(Export record);
    
    List<Export> getAll();

	void updateState(Map<String,Object> map);
    
 
}