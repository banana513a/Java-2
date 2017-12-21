package com.blackybear.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class FilmCategoryKey {
    private Short filmId;

    private Byte categoryId;

}