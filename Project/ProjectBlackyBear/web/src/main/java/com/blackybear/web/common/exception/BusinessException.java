package com.blackybear.web.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: BusinessException
 * Author: qinweitao
 * CopyRight: blackybear
 * Create Date: 2017-12-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private int code;
    private String message;
}
