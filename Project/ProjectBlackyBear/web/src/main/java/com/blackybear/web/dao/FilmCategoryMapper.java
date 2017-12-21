package com.blackybear.web.dao;

import com.blackybear.web.entity.FilmCategory;
import com.blackybear.web.entity.FilmCategoryKey;

public interface FilmCategoryMapper {
    int deleteByPrimaryKey(FilmCategoryKey key);

    int insert(FilmCategory record);

    int insertSelective(FilmCategory record);

    FilmCategory selectByPrimaryKey(FilmCategoryKey key);

    int updateByPrimaryKeySelective(FilmCategory record);

    int updateByPrimaryKey(FilmCategory record);
}