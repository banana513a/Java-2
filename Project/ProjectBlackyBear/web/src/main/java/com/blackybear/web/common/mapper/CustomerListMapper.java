package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.CustomerList;

import java.util.List;

public interface CustomerListMapper {
    List<CustomerList> selectCustomerListList();

    CustomerList selectCustomListById(Short id);
}