package com.blackybear.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: Regular Expression Utility
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class RegExpUtil {
    //整数或者小数：^[0-9]+\.{0,1}[0-9]{0,2}$
    public static final String REGEXP_INTEGER_DECIMAL = "^[0-9]+\\.{0,1}[0-9]{0,2}$";
    //只能输入数字："^[0-9]*$"
    public static final String REGEXP_NUMBER = "^[0-9]*$";
    //只能输入n位的数字："^\d{n}$"
    public static final String REGEXP_NUMBER_FIXLENGTH="^\\d{6}$";
    //只能输入至少n位的数字："^\d{n,}$"
    public static final String REGEXP_NUMBER_MIN="^\\d{6,}$";
    //只能输入m~n位的数字：。"^\d{m,n}$"
    public static final String REGEXP_NUMBER_RANGE="^\\d{6,8}";
    //只能输入零和非零开头的数字："^(0|[1-9][0-9]*)$"
    public static final String REGEXP_NUMBER_ZERO="^(0|[1-9][0-9]*)$";
    //只能输入有两位小数的正实数："^[0-9]+(.[0-9]{2})?$"
    public static final String REGEXP_DECIMAL_FIXLENGTH="^[0-9]+(.[0-9]{2})?$";
    //只能输入有1~3位小数的正实数："^[0-9]+(.[0-9]{1,3})?$"
    public static final String REGEXP_DECIMAL_RANGELENGTH="^[0-9]+(.[0-9]{1,3})?$";
    //只能输入非零的正整数："^\+?[1-9][0-9]*$"
    public static final String REGEXP_INTEGER_NOZEROPOSITIVE="^\\+?[1-9][0-9]*$";
    //只能输入非零的负整数："^\-[1-9][0-9]*$"
    public static final String REGEXP_INTEGER_NOZERONEGATIVE="^\\-?[1-9][0-9]*$";
    //只能输入长度为3的字符："^.{3}$"
    public static final String REGEXP_CHAR_FIXLENGTH="^.{6}$";
    //只能输入由26个英文字母组成的字符串："^[A-Za-z]+$"
    public static final String REGEXP_CHAR_ALL="^[A-Za-z]+$";
    //只能输入由26个大写英文字母组成的字符串："^[A-Z]+$"
    public static final String REGEXP_CHAR_UPPERCASE="^[A-Z]+$";
    //只能输入由26个小写英文字母组成的字符串："^[a-z]+$"
    public static final String REGEXP_CHAR_LOWERCASE="^[a-z]+$";
    //只能输入由数字和26个英文字母组成的字符串："^[A-Za-z0-9]+$"。
    public static final String REGEXP_CHAR_NUMBER="^[A-Za-z0-9]+$";
    //只能输入由数字、26个英文字母或者下划线组成的字符串："^\w+$"。
    public static final String REGEXP_CHAR_UNDERLINE="^\\w+$";
    //验证用户密码："^[a-zA-Z]\w{5,17}$"（以字母开头，长度在6~18之间，只能包含字符、数字和下划线）
    public static final String REGEXP_USERNAME="^[a-zA-Z]\\w{5,17}$";
    //验证是否含有^%&',;=?$\"等字符："[^%&',;=?$\x22]+"。
    public static final String REGEXP_CHAR_SPECIAL="^[^%&',;=?$\\x22]+$";
    //只能输入汉字："^[\u4e00-\u9fa5]{0,}$"
    public static final String REGEXP_CHAR_CHINA="^[\u4e00-\u9fa5]{0,}$";
    //验证Email地址："^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$"
    public static final String REGEXP_EMAIL="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    //验证InternetURL："^http://([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$"
    public static final String REGEXP_INTERNETURL="^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
    //验证身份证号码（15位或18位，最后一位可能是数字或字母）："^\d{15}|\d{18}$"
    public static final String REGEXP_IDENTITYCARD="^[1-9]\\d{13,16}[a-zA-Z0-9]{1}$";
    //验证一年的12个月："^(0?[1-9]|1[0-2])$"正确格式为："01"～"09"和"1"～"12"
    public static final String REGEXP_DATE_MONTH="^(0?[1-9]|1[0-2])$";
    //验证一个月的31天："^((0?[1-9])|((1|2)[0-9])|30|31)$"正确格式为；"01"～"09"和"1"～"31"。
    public static final String REGEXP_DATE_DAYOFMONTH="^((0?[1-9])|((1|2)[0-9])|30|31)$";
    //匹配双字节字符(包括汉字在内)：[^\x00-\xff]
    //应用：计算字符串的长度（一个双字节字符长度计2，ASCII字符计1）
    //String.prototype.len=function(){return this.replace(/[^\x00-\xff]/g,"aa").length;}
    public static final String REGEXP_DWORD="^[^\\x00-\\xff]$";
    //匹配空行的正则表达式：\n[\s| ]*\r
    public static final String REGEXP_BLANKLINE="\\n[\\s| ]*\\r";
    //匹配html标签的正则表达式：<(.*)>(.*)<\/(.*)>|<(.*)\/>
    public static final String REGEXP_HTMLTAG="<(.*)>(.*)<\\/(.*)>|\\<(.*)\\/>";
    //匹配首尾空格的正则表达式：(^\s*)|(\s*$)
    public static final String REGEXP_ENDSPACE="(^\\s*)|(\\s*$)";
    //匹配IP地址
    public static final String REGEXP_IP="^([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}$";
    /**
     *手机号码
     *移动：134[0-8],135,136,137,138,139,150,151,157,158,159,182,187,188
     *联通：130,131,132,152,155,156,185,186
     *电信：133,1349,153,180,189
     **/
    //中国移动：ChinaMobile: 134[0-8],135,136,137,138,139,150,151,157,158,159,182,187,188
    public static final String REGEXP_CHINAMOBILE="^1(34[0-8]|(3[5-9]|5[017-9]|8[278])\\d)\\d{7}$";
    //中国联通：ChinaUnicom: 130,131,132,152,155,156,185,186
    public static final String REGEXP_CHINAUNICOM="^1(3[0-2]|5[256]|8[56])\\d{8}$";
    //中国电信：ChinaTelecom: 133,1349,153,180,189
    public static final String REGEXP_CHINATELECOM="^1((33|53|8[09])[0-9]|349)\\d{7}$";
    /**
     * 大陆地区固话及小灵通
     * 区号：010,020,021,022,023,024,025,027,028,029
     * 号码：七位或八位
     */
    public static final String REGEXP_PHS="^0(10|2[0-5789]|\\d{3})\\d{7,8}$";


    public static boolean verifiyByRegExp(String value ,String patternType){
        Pattern pattern = Pattern.compile(patternType);
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches())
            return true;
        return false;
    }
}
