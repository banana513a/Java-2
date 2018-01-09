package com.blackybear.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Language {
    private Byte languageId;

    private String name;

    private Date lastUpdate;
}