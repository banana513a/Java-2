package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.FilmCategory;
import com.blackybear.web.common.entity.FilmCategoryKey;

public interface FilmCategoryMapper {
    int deleteByPrimaryKey(FilmCategoryKey key);

    int insert(FilmCategory record);

    int insertSelective(FilmCategory record);

    FilmCategory selectByPrimaryKey(FilmCategoryKey key);

    int updateByPrimaryKeySelective(FilmCategory record);

    int updateByPrimaryKey(FilmCategory record);
}