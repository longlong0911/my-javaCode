package com.sun.dao;

import java.util.List;

import com.sun.entity.ContractProduct;
import com.sun.entity.ExtCproduct;

public interface ExtCproductMapper {
    int deleteByPrimaryKey(String id);

    int insert(ExtCproduct record);

    int insertSelective(ExtCproduct record);

    ExtCproduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExtCproduct record);

    int updateByPrimaryKey(ExtCproduct record);
    
    List<ExtCproduct> getAll();
    public void delete(String[] ids);
    List<ExtCproduct> selectByParam(String id);
    int deleteByContractId(String contractId);
    
}