package com.blackybear.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class FilmCategory extends FilmCategoryKey {
    private Date lastUpdate;
}