package com.blackybear.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class Payment {
    private Short paymentId;

    private Short customerId;

    private Byte staffId;

    private Integer rentalId;

    private BigDecimal amount;

    private Date paymentDate;

    private Date lastUpdate;

}