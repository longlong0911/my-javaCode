package com.sun.dao;

import java.util.List;

import com.sun.entity.ExportProduct;

public interface ExportProductMapper {
    int deleteByPrimaryKey(String exportProductId);

    int insert(ExportProduct record);

    int insertSelective(ExportProduct record);

    ExportProduct selectByPrimaryKey(String exportProductId);

    int updateByPrimaryKeySelective(ExportProduct record);

    int update(ExportProduct record);
    
    void deleteByExportId(String exportId);
    
    List<ExportProduct> findByExportId(String exportId);
}