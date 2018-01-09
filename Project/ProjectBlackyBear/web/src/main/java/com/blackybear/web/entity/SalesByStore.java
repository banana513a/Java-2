package com.blackybear.web.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SalesByStore {
    private String store;

    private String manager;

    private BigDecimal totalSales;

}