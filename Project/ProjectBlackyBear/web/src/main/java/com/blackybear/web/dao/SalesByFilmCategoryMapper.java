package com.blackybear.web.dao;

import com.blackybear.web.entity.SalesByFilmCategory;

import java.util.List;

public interface SalesByFilmCategoryMapper {
    List<SalesByFilmCategory> selectSalesByFilmCategoryList();

    SalesByFilmCategory selectSalesByFilmCategoryByCategory(String category);
}