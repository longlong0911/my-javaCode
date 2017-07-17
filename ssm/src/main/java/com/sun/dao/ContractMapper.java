package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.Contract;
import com.sun.vo.ContractVO;

public interface ContractMapper {
    int deleteByPrimaryKey(String id);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
    
    List<Contract> getAll();
    public void delete(String[] ids);
    public void updateState(Map<String,Object> map);
    ContractVO selectView(String id);
    public void deleteByContractId(String contractId);
    
}
