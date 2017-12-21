package com.blackybear.web.dao;

import com.blackybear.web.entity.StaffList;

import java.util.List;

public interface StaffListMapper {
    List<StaffList> selectStaffListList();

    StaffList selectStaffListById(Byte id);
}