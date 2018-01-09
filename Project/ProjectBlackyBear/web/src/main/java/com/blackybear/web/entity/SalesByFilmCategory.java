package com.blackybear.web.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SalesByFilmCategory {
    private String category;

    private BigDecimal totalSales;
}