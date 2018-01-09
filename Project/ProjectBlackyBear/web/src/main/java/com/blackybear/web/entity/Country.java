package com.blackybear.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Country {
    private Short countryId;

    private String country;

    private Date lastUpdate;
}