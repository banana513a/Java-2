package com.blackybear.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class Inventory {
    private Integer inventoryId;

    private Short filmId;

    private Byte storeId;

    private Date lastUpdate;
}