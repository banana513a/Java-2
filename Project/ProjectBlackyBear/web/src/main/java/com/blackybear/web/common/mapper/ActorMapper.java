package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.Actor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActorMapper {
    int deleteByPrimaryKey(Short actorId);

    int insert(Actor actor);

    int insertSelective(Actor actor);

    Actor selectByPrimaryKey(Short actorId);

    int updateByPrimaryKeySelective(Actor actor);

    int updateByPrimaryKey(Actor actor);

    List<Actor> selectActorList(@Param("pageNum") int pageNum,
                                @Param("pageSize") int pageSize);
}