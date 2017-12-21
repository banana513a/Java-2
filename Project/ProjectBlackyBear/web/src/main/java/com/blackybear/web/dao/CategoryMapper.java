package com.blackybear.web.dao;

import com.blackybear.web.entity.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Byte categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Byte categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}