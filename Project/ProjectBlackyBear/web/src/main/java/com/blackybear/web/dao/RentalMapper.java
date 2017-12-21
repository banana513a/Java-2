package com.blackybear.web.dao;

import com.blackybear.web.entity.Rental;

public interface RentalMapper {
    int deleteByPrimaryKey(Integer rentalId);

    int insert(Rental record);

    int insertSelective(Rental record);

    Rental selectByPrimaryKey(Integer rentalId);

    int updateByPrimaryKeySelective(Rental record);

    int updateByPrimaryKey(Rental record);
}