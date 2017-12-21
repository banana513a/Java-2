package com.blackybear.web.dao;

import com.blackybear.web.entity.Film;

public interface FilmMapper {
    int deleteByPrimaryKey(Short filmId);

    int insert(Film record);

    int insertSelective(Film record);

    Film selectByPrimaryKey(Short filmId);

    int updateByPrimaryKeySelective(Film record);

    int updateByPrimaryKeyWithBLOBs(Film record);

    int updateByPrimaryKey(Film record);
}