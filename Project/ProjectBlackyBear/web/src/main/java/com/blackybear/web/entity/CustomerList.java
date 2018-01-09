package com.blackybear.web.entity;

import lombok.Data;

@Data
public class CustomerList {
    private Short id;

    private String name;

    private String address;

    private String zipCode;

    private String phone;

    private String city;

    private String country;

    private String notes;

    private Byte sid;

}