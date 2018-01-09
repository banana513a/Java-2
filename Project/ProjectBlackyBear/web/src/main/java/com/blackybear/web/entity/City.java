package com.blackybear.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class City {
    private Short cityId;

    private String city;

    private Short countryId;

    private Date lastUpdate;

}