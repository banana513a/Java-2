package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.Store;

public interface StoreMapper {
    int deleteByPrimaryKey(Byte storeId);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Byte storeId);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}