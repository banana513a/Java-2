package com.blackybear.web.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NicerButSlowerFilmList {
    private Short fid;

    private String title;

    private String category;

    private BigDecimal price;

    private Short length;

    private String rating;

    private String description;

    private String actors;

}