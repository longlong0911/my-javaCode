package com.sun.dao;

import com.sun.entity.Invoice;

public interface InvoiceMapper {
    int deleteByPrimaryKey(String invoiceId);

    int insert(Invoice record);

    int insertSelective(Invoice record);

    Invoice selectByPrimaryKey(String invoiceId);

    int updateByPrimaryKeySelective(Invoice record);

    int updateByPrimaryKey(Invoice record);
}