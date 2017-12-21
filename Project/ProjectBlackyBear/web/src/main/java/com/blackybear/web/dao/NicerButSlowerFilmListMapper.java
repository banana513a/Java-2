package com.blackybear.web.dao;

import com.blackybear.web.entity.NicerButSlowerFilmList;

import java.util.List;

public interface NicerButSlowerFilmListMapper {
    List<NicerButSlowerFilmList> selectNicerButSlowerFilmListList();

    NicerButSlowerFilmList selectNicerButSlowerFilmListById(Short fid);
}