package com.blackybear.web.entity;

import lombok.Data;

@Data
public class ActorInfo {
    private Short actorId;

    private String firstName;

    private String lastName;

    private String filmInfo;
}