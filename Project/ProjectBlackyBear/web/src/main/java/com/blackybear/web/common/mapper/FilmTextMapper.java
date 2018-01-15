package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.FilmText;

public interface FilmTextMapper {
    int deleteByPrimaryKey(Short filmId);

    int insert(FilmText record);

    int insertSelective(FilmText record);

    FilmText selectByPrimaryKey(Short filmId);

    int updateByPrimaryKeySelective(FilmText record);

    int updateByPrimaryKeyWithBLOBs(FilmText record);

    int updateByPrimaryKey(FilmText record);
}