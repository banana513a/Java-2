package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Short addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Short addressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKeyWithBLOBs(Address record);

    int updateByPrimaryKey(Address record);
}