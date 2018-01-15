package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.Payment;

public interface PaymentMapper {
    int deleteByPrimaryKey(Short paymentId);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Short paymentId);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}