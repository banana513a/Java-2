package com.blackybear.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class Language {
    private Byte languageId;

    private String name;

    private Date lastUpdate;
}