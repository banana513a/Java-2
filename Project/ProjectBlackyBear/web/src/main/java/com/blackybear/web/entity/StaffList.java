package com.blackybear.web.entity;

import lombok.Data;

@Data
public class StaffList {
    private Byte id;

    private String name;

    private String address;

    private String zipCode;

    private String phone;

    private String city;

    private String country;

    private Byte sid;
}