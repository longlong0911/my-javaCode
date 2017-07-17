package com.sun.dao;

import java.util.List;

import com.sun.entity.Code;

public interface CodeMapper {
    int deleteByPrimaryKey(String sysCodeId);

    int insert(Code record);

    int insertSelective(Code record);

    Code selectByPrimaryKey(String sysCodeId);

    int updateByPrimaryKeySelective(Code record);

    int updateByPrimaryKey(Code record);
    
    List<Code> getAll();
}