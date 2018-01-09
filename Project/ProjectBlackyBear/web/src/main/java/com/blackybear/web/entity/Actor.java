package com.blackybear.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Actor {
    private Short actorId;

    private String firstName;

    private String lastName;

    private Date lastUpdate;
}