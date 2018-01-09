package com.blackybear.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Inventory {
    private Integer inventoryId;

    private Short filmId;

    private Byte storeId;

    private Date lastUpdate;
}