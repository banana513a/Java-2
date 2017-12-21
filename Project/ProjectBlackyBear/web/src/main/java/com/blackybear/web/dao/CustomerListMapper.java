package com.blackybear.web.dao;

import com.blackybear.web.entity.CustomerList;

import java.util.List;

public interface CustomerListMapper {
    List<CustomerList> selectCustomerListList();

    CustomerList selectCustomListById(Short id);
}