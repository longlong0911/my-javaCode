package com.sun.dao;

import java.util.List;

import com.sun.entity.PackingList;

public interface PackingListMapper {
    int deleteByPrimaryKey(String packingListId);

    int insert(PackingList record);

    int insertSelective(PackingList record);

    PackingList selectByPrimaryKey(String packingListId);

    int updateByPrimaryKeySelective(PackingList record);

    int updateByPrimaryKey(PackingList record);
    
    List<PackingList> find();
}