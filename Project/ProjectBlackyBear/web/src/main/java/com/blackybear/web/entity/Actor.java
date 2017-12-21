package com.blackybear.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class Actor {
    private Short actorId;

    private String firstName;

    private String lastName;

    private Date lastUpdate;
}