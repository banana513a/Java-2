package com.blackybear.web.dao;

import com.blackybear.web.entity.FilmList;

import java.util.List;

public interface FilmListMapper {
    List<FilmList> selectFilmList();

    FilmList selectFilmListById(Short fid);
}