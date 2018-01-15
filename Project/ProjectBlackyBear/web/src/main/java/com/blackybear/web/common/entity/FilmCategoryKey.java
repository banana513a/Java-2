package com.blackybear.web.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategoryKey {
    private Short filmId;

    private Byte categoryId;

}