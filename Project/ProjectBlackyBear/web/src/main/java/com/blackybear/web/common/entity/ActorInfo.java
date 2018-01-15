package com.blackybear.web.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorInfo {
    private Short actorId;

    private String firstName;

    private String lastName;

    private String filmInfo;
}