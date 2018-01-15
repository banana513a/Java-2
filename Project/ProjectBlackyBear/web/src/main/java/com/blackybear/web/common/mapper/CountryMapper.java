package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.Country;

public interface CountryMapper {
    int deleteByPrimaryKey(Short countryId);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(Short countryId);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}