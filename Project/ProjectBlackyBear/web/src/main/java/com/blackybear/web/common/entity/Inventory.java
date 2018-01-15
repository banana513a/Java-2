package com.blackybear.web.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    private Integer inventoryId;

    private Short filmId;

    private Byte storeId;

    private Date lastUpdate;
}