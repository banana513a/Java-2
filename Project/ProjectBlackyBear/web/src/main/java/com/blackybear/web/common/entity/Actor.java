package com.blackybear.web.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    private Short actorId;

    private String firstName;

    private String lastName;

    private Date lastUpdate;
}