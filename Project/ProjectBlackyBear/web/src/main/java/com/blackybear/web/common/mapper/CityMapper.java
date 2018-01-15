package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.City;

public interface CityMapper {
    int deleteByPrimaryKey(Short cityId);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Short cityId);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}