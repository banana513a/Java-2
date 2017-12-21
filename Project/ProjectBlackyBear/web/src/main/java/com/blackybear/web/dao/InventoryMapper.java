package com.blackybear.web.dao;

import com.blackybear.web.entity.Inventory;

public interface InventoryMapper {
    int deleteByPrimaryKey(Integer inventoryId);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Integer inventoryId);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);
}