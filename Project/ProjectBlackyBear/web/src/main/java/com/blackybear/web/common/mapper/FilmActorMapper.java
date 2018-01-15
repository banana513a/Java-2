package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.FilmActor;
import com.blackybear.web.common.entity.FilmActorKey;

public interface FilmActorMapper {
    int deleteByPrimaryKey(FilmActorKey key);

    int insert(FilmActor record);

    int insertSelective(FilmActor record);

    FilmActor selectByPrimaryKey(FilmActorKey key);

    int updateByPrimaryKeySelective(FilmActor record);

    int updateByPrimaryKey(FilmActor record);
}