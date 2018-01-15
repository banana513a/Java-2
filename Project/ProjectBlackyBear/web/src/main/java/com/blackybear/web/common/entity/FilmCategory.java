package com.blackybear.web.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategory extends FilmCategoryKey {
    private Date lastUpdate;
}