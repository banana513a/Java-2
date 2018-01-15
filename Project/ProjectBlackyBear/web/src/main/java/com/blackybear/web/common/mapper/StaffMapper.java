package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(Byte staffId);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Byte staffId);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKeyWithBLOBs(Staff record);

    int updateByPrimaryKey(Staff record);
}