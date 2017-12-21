package com.blackybear.web.dao;

import com.blackybear.web.entity.ActorInfo;

import java.util.List;

public interface ActorInfoMapper {
    ActorInfo selectByActorId(Short actorId);

    List<ActorInfo> selectActorInfoList();
}