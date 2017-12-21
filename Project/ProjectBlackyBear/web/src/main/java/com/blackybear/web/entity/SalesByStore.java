package com.blackybear.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@EqualsAndHashCode
public class SalesByStore {
    private String store;

    private String manager;

    private BigDecimal totalSales;

}