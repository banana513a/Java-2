package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Short customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Short customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}