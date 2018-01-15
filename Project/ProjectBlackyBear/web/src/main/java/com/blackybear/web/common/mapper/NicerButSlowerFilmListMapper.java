package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.NicerButSlowerFilmList;

import java.util.List;

public interface NicerButSlowerFilmListMapper {
    List<NicerButSlowerFilmList> selectNicerButSlowerFilmListList();

    NicerButSlowerFilmList selectNicerButSlowerFilmListById(Short fid);
}