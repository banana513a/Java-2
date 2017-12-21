package com.blackybear.web.dao;

import com.blackybear.web.entity.FilmText;

public interface FilmTextMapper {
    int deleteByPrimaryKey(Short filmId);

    int insert(FilmText record);

    int insertSelective(FilmText record);

    FilmText selectByPrimaryKey(Short filmId);

    int updateByPrimaryKeySelective(FilmText record);

    int updateByPrimaryKeyWithBLOBs(FilmText record);

    int updateByPrimaryKey(FilmText record);
}