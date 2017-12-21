package com.blackybear.web.dao;

import com.blackybear.web.entity.Actor;

public interface ActorMapper {
    int deleteByPrimaryKey(Short actorId);

    int insert(Actor actor);

    int insertSelective(Actor actor);

    Actor selectByPrimaryKey(Short actorId);

    int updateByPrimaryKeySelective(Actor actor);

    int updateByPrimaryKey(Actor actor);
}