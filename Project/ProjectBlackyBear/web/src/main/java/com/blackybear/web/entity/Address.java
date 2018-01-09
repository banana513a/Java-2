package com.blackybear.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Address {
    private Short addressId;

    private String address;

    private String address2;

    private String district;

    private Short cityId;

    private String postalCode;

    private String phone;

    private Date lastUpdate;

    private byte[] location;
}