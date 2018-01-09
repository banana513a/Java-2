package com.blackybear.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Store {
    private Byte storeId;

    private Byte managerStaffId;

    private Short addressId;

    private Date lastUpdate;
}