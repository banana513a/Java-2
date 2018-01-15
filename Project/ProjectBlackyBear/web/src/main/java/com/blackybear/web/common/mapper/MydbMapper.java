package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.Mydb;

public interface MydbMapper {
    int insert(Mydb record);

    int insertSelective(Mydb record);
}