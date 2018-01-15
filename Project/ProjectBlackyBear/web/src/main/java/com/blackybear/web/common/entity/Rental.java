package com.blackybear.web.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
    private Integer rentalId;

    private Date rentalDate;

    private Integer inventoryId;

    private Short customerId;

    private Date returnDate;

    private Byte staffId;

    private Date lastUpdate;

}