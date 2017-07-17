package com.sun.dao;

import java.util.List;

import com.sun.entity.Contract;
import com.sun.entity.ContractProduct;

public interface ContractProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(ContractProduct record);

    int insertSelective(ContractProduct record);

    ContractProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ContractProduct record);

    int updateByPrimaryKey(ContractProduct record);
    
    List<ContractProduct> getAll();
    public void delete(String[] ids);
    List<ContractProduct> selectByParam(String contractId);
    int deleteByContractId(String contractId);

    
}