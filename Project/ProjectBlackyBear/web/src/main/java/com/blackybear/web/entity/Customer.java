package com.blackybear.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {
    private Short customerId;

    private Byte storeId;

    private String firstName;

    private String lastName;

    private String email;

    private Short addressId;

    private Boolean active;

    private Date createDate;

    private Date lastUpdate;
}