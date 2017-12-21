package com.blackybear.web.dao;

import com.blackybear.web.entity.FilmActor;
import com.blackybear.web.entity.FilmActorKey;

public interface FilmActorMapper {
    int deleteByPrimaryKey(FilmActorKey key);

    int insert(FilmActor record);

    int insertSelective(FilmActor record);

    FilmActor selectByPrimaryKey(FilmActorKey key);

    int updateByPrimaryKeySelective(FilmActor record);

    int updateByPrimaryKey(FilmActor record);
}