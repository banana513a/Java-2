package com.blackybear.web.dao;

import com.blackybear.web.entity.Payment;

public interface PaymentMapper {
    int deleteByPrimaryKey(Short paymentId);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Short paymentId);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}