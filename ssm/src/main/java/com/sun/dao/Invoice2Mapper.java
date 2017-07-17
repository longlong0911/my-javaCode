package com.sun.dao;

import com.sun.entity.Invoice2;

public interface Invoice2Mapper {
    int deleteByPrimaryKey(String invoiceId);

    int insert(Invoice2 record);

    int insertSelective(Invoice2 record);

    Invoice2 selectByPrimaryKey(String invoiceId);

    int updateByPrimaryKeySelective(Invoice2 record);

    int updateByPrimaryKey(Invoice2 record);
}