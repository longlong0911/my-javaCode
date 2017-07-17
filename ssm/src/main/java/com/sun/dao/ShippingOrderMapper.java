package com.sun.dao;

import com.sun.entity.ShippingOrder;

public interface ShippingOrderMapper {
    int deleteByPrimaryKey(String shippingOrderId);

    int insert(ShippingOrder record);

    int insertSelective(ShippingOrder record);

    ShippingOrder selectByPrimaryKey(String shippingOrderId);

    int updateByPrimaryKeySelective(ShippingOrder record);

    int updateByPrimaryKey(ShippingOrder record);
}