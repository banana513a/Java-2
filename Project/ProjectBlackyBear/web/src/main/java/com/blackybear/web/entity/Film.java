package com.blackybear.web.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Film {
    private Short filmId;

    private String title;

    private Date releaseYear;

    private Byte languageId;

    private Byte originalLanguageId;

    private Byte rentalDuration;

    private BigDecimal rentalRate;

    private Short length;

    private BigDecimal replacementCost;

    private String rating;

    private String specialFeatures;

    private Date lastUpdate;

    private String description;

}