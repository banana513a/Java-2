package com.blackybear.web.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    private Byte storeId;

    private Byte managerStaffId;

    private Short addressId;

    private Date lastUpdate;
}