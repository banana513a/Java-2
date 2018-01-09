package com.blackybear.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Byte categoryId;

    private String name;

    private Date lastUpdate;
}