package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.FilmList;

import java.util.List;

public interface FilmListMapper {
    List<FilmList> selectFilmList();

    FilmList selectFilmListById(Short fid);
}