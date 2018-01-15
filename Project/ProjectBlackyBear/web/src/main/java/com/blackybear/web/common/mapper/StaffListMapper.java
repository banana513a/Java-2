package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.StaffList;

import java.util.List;

public interface StaffListMapper {
    List<StaffList> selectStaffListList();

    StaffList selectStaffListById(Byte id);
}