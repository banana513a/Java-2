package com.blackybear.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class City {
    private Short cityId;

    private String city;

    private Short countryId;

    private Date lastUpdate;

}