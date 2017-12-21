package com.blackybear.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class Store {
    private Byte storeId;

    private Byte managerStaffId;

    private Short addressId;

    private Date lastUpdate;
}