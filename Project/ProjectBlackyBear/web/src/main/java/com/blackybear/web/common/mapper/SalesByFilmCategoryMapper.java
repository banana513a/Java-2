package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.SalesByFilmCategory;

import java.util.List;

public interface SalesByFilmCategoryMapper {
    List<SalesByFilmCategory> selectSalesByFilmCategoryList();

    SalesByFilmCategory selectSalesByFilmCategoryByCategory(String category);
}