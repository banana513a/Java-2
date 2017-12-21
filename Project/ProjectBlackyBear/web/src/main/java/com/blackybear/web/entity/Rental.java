package com.blackybear.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class Rental {
    private Integer rentalId;

    private Date rentalDate;

    private Integer inventoryId;

    private Short customerId;

    private Date returnDate;

    private Byte staffId;

    private Date lastUpdate;

}