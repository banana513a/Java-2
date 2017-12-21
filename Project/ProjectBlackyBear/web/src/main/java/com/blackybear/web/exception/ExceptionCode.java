package com.blackybear.web.exception;

/**
 * Description: ExceptionCode
 * Author: qinweitao
 * CopyRight: blackybear
 * Create Date: 2017-12-03
 */
public class ExceptionCode {
    public static final int RESPONSE_CODE_SUCCESS = 0;
    public static final String RESPONSE_MSG_SUCCESS = "请求成功";

    //region 系统异常(范围：10-100)
    public static final int EXP_UNAUTHORIZED = 10;
    public static final String EXP_UNAUTHORIZED_MSG = "系统异常，用户无访问权限";
    public static final int EXP_PARAM_INVALID = 11;
    public static final String EXP_PARAM_INVALID_MSG = "系统异常，请求参数错误";
    public static final int EXP_DB = 12;
    public static final String EXP_DB_MSG = "系统异常，数据错误";
    public static final int EXP_MAPPER_INVALID = 13;
    public static final String EXP_MAPPER_INVALID_MSG = "系统异常，数据字段映射错误";
    public static final int EXP_NO_DATA = 14;
    public static final String EXP_NO_DATA_MSG = "数据异常，无法获取数据";

    public static final int EXP_SYSTEM_UNKOWN_CODE = 100;
    public static final String EXP_SYSTEM_UNKOWN_MSG = "系统异常，未知错误！";
    //endregion
}
