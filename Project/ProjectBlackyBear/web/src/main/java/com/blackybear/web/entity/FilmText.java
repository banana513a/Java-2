package com.blackybear.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class FilmText {
    private Short filmId;

    private String title;

    private String description;
}