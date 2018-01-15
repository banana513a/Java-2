package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.ActorInfo;

import java.util.List;

public interface ActorInfoMapper {
    ActorInfo selectByActorId(Short actorId);

    List<ActorInfo> selectActorInfoList();
}