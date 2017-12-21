package com.blackybear.web.dao;

import com.blackybear.web.entity.Mydb;

public interface MydbMapper {
    int insert(Mydb record);

    int insertSelective(Mydb record);
}