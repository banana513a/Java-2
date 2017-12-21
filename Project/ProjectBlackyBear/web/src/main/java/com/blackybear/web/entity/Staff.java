package com.blackybear.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class Staff {
    private Byte staffId;

    private String firstName;

    private String lastName;

    private Short addressId;

    private String email;

    private Byte storeId;

    private Boolean active;

    private String username;

    private String password;

    private Date lastUpdate;

    private byte[] picture;
}