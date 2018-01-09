package com.blackybear.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class FilmActor extends FilmActorKey {
    private Date lastUpdate;
}