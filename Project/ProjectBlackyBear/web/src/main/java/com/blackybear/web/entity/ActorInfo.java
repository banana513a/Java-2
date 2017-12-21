package com.blackybear.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class ActorInfo {
    private Short actorId;

    private String firstName;

    private String lastName;

    private String filmInfo;
}