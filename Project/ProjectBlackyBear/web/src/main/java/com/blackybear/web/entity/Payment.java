package com.blackybear.web.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Payment {
    private Short paymentId;

    private Short customerId;

    private Byte staffId;

    private Integer rentalId;

    private BigDecimal amount;

    private Date paymentDate;

    private Date lastUpdate;

}