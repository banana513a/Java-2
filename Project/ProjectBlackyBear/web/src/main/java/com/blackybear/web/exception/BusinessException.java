package com.blackybear.web.exception;

/**
 * Description: BusinessException
 * Author: qinweitao
 * CopyRight: blackybear
 * Create Date: 2017-12-03
 */
public class BusinessException extends RuntimeException {
    private int code;
    private String message;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
