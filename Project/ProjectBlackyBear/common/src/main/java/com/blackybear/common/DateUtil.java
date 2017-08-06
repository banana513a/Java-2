package com.blackybear.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Description: Date Utility
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class DateUtil {
    /** 毫秒 */
    private final static long MS = 1;
    /** 每秒钟的毫秒数 */
    private final static long SECOND_MS = MS * 1000;
    /** 每分钟的毫秒数 */
    private final static long MINUTE_MS = SECOND_MS * 60;
    /** 每小时的毫秒数 */
    private final static long HOUR_MS = MINUTE_MS * 60;
    /** 每天的毫秒数 */
    public final static long DAY_MS = HOUR_MS * 24;

    /** 标准日期格式 */
    private final static String NORM_DATE_PATTERN = "yyyy-MM-dd";
    /** 标准时间格式 */
    private final static String NORM_TIME_PATTERN = "HH:mm:ss";
    /** 标准日期时间格式 */
    private final static String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /** 标准日期中文格式 */
    private final static String NORM_DATE_CN_PATTERN =     "yyyy年MM月dd日";
    /** 标准日期星期中文格式 */
    private final static String NORM_DATE_WEEK_CN_PATTERN = "yyyy年MM月dd日 EEEE";
    /** HTTP头中日期时间格式 */
    private final static String HTTP_DATETIME_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";


    /** 标准日期（不含时间）格式化器 */
    private final static SimpleDateFormat NORM_DATE_FORMAT = new SimpleDateFormat(NORM_DATE_PATTERN);
    /** 标准时间格式化器 */
    private final static SimpleDateFormat NORM_TIME_FORMAT = new SimpleDateFormat(NORM_TIME_PATTERN);
    /** 标准日期时间格式化器 */
    private final static SimpleDateFormat NORM_DATETIME_FORMAT = new SimpleDateFormat(NORM_DATETIME_PATTERN);
    /** 标准日期中文格式化器 */
    private final static SimpleDateFormat NORM_DATE_CN_FORMAT = new SimpleDateFormat(NORM_DATE_CN_PATTERN);
    /** 标准日期星期中文格式化器 */
    private final static SimpleDateFormat NORM_DATE_WEEK_CN_FORMAT = new SimpleDateFormat(NORM_DATE_WEEK_CN_PATTERN);
    /** HTTP日期时间格式化器 */
    private final static SimpleDateFormat HTTP_DATETIME_FORMAT = new SimpleDateFormat(HTTP_DATETIME_PATTERN, Locale.US);

    /**
     * 是否闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        boolean flag = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        return flag;
    }

    /**
     * 是否闰年
     * @param date
     * @return
     */
    public static boolean isLeapYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        boolean flag = isLeapYear(cal.get(Calendar.YEAR));
        return flag;
    }

    //region CurrentTime
    /**
     * 获取当前时间
     * @return
     */
    public static Date now() {
        return new Date();
    }

    /**
     * 获取当前时间(毫秒)
     * @return
     */
    public static long getCurrentTimeInMillis(){
        return Calendar.getInstance().getTimeInMillis();
    }

    /**
     * 当前时间，格式 yyyy-MM-dd HH:mm:ss
     * @return 当前时间的标准形式字符串
     */
    public static String getCurrentDateTime() {
        return formatDateTime(new Date());
    }

    /**
     * 当前日期，格式 yyyy-MM-dd
     * @return 当前日期的标准形式字符串
     */
    public static String getCurrentDate() {
        return formatDate(new Date());
    }

    /**
     * 当前时间，格式 HH:mm:ss
     * @return 当前日期的标准形式字符串
     */
    public static String getCurrentTime() {
        return formatTime(new Date());
    }

    /**
     * 当前时间，格式 yyyy年MM月dd日
     * @return 当前日期的标准形式字符串
     */
    public static String getCurrentDateCN() {
        return formatDateCN(new Date());
    }

    /**
     * 当前时间，格式 yyyy年MM月dd日 星期E
     * @return 当前日期的标准形式字符串
     */
    public static String getCurrentDateWeekCN() {
        return formatDateWeekCN(new Date());
    }
    //endregion

    //region Date2String
    /**
     * 根据特定格式格式化日期
     * @param date 被格式化的日期
     * @param format 格式
     * @return 格式化后的字符串
     */
    public static String format(Date date, String format){
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 格式 yyyy-MM-dd
     * @param date 被格式化的日期
     * @return 格式化后的字符串
     */
    public static String formatDate(Date date) {
        return NORM_DATE_FORMAT.format(date);
    }

    /**
     * 格式 HH:mm:ss
     * @param date 被格式化的日期
     * @return 格式化后的时间
     */
    public static String formatTime(Date date) {
        return NORM_TIME_FORMAT.format(date);
    }

    /**
     * 格式 yyyy-MM-dd HH:mm:ss
     * @param date 被格式化的日期
     * @return 格式化后的日期
     */
    public static String formatDateTime(Date date) {
        return NORM_DATETIME_FORMAT.format(date);
    }

    /**
     * 格式化为Http的标准日期格式
     * @param date 被格式化的日期
     * @return HTTP标准形式日期字符串
     */
    public static String formatHttpDate(Date date) {
        return HTTP_DATETIME_FORMAT.format(date);
    }
    //endregion

    //region Date2String(CN)
    /**
     * 获得星期几(周日为1，周六为7)
     * @param date
     * 		给定日期
     * @return
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获得星期几（中文）
     * @param date
     * @return
     */
    public static String getDayCN(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            default:
                return "";
        }
    }

    /**
     * 格式 yyyy年MM月dd日
     * @param date 被格式化的日期
     * @return 格式化后的日期
     */
    public static String formatDateCN(Date date) {
        return NORM_DATE_CN_FORMAT.format(date);
    }

    /**
     * 格式 yyyy年MM月dd日 星期E
     * @param date 被格式化的日期
     * @return 格式化后的日期
     */
    public static String formatDateWeekCN(Date date) {
        return NORM_DATE_WEEK_CN_FORMAT.format(date);
    }
    //endregion

    //region String2Date
    /**
     * 将特定格式的日期转换为Date对象
     * @param dateString 特定格式的日期
     * @param format 格式，例如yyyy-MM-dd
     * @return 日期对象
     */
    public static Date parse(String dateString, String format){
        try {
            return (new SimpleDateFormat(format)).parse(dateString);
        } catch (ParseException e) {
            System.out.println("Parse " + dateString + " with format " + format + " error!");
        }
        return null;
    }

    /**
     * 格式yyyy-MM-dd
     * @param dateString 标准形式的日期字符串
     * @return 日期对象
     */
    public static Date parseDate(String dateString){
        try {
            return NORM_DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Parse " + dateString + " with format " + NORM_DATE_PATTERN + " error!");
        }
        return null;
    }

    /**
     * 格式HH:mm:ss
     * @param timeString 标准形式的日期字符串
     * @return 日期对象
     */
    public static Date parseTime(String timeString){
        try {
            return NORM_TIME_FORMAT.parse(timeString);
        } catch (ParseException e) {
            System.out.println("Parse " + timeString + " with format " + NORM_TIME_PATTERN + " error!");
        }
        return null;
    }

    /**
     * 格式yyyy-MM-dd HH:mm:ss
     * @param dateString 标准形式的时间字符串
     * @return 日期对象
     */
    public static Date parseDateTime(String dateString){
        try {
            return NORM_DATETIME_FORMAT.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Parse " + dateString + " with format " + NORM_DATETIME_FORMAT.toPattern() + " error!");
        }
        return null;
    }

    /**
     * 格式：<br>
     * 1、yyyy-MM-dd HH:mm:ss<br>
     * 2、yyyy-MM-dd<br>
     * 3、HH:mm:ss
     * @param dateStr 日期字符串
     * @return 日期
     */
    public static Date parse(String dateStr) {
        int length = dateStr.length();
        try {
            if(length == DateUtil.NORM_DATETIME_PATTERN.length()) {
                return parseDateTime(dateStr);
            }else if(length == DateUtil.NORM_DATE_PATTERN.length()) {
                return parseDate(dateStr);
            }else if(length == DateUtil.NORM_TIME_PATTERN.length()){
                return parseTime(dateStr);
            }
        }catch(Exception e) {
            System.out.println("Parse " + dateStr + " with format normal error!");
        }
        return null;
    }
    //endregion

    //region OffSet
    /**
     * 昨天
     * @return 昨天
     */
    public static Date yesterday() {
        return offsiteDate(new Date(), Calendar.DAY_OF_YEAR, -1);
    }

    /**
     * 上周
     * @return 上周
     */
    public static Date lastWeek() {
        return offsiteDate(new Date(), Calendar.WEEK_OF_YEAR, -1);
    }

    /**
     * 上个月
     * @return 上个月
     */
    public static Date lastMouth() {
        return offsiteDate(new Date(), Calendar.MONTH, -1);
    }

    /**
     * 获取指定日期偏移指定时间后的时间
     * @param date 基准日期
     * @param calendarField 偏移的粒度大小（小时、天、月等）使用Calendar中的常数
     * @param offsite 偏移量，正数为向后偏移，负数为向前偏移
     * @return 偏移后的日期
     */
    public static Date offsiteDate(Date date, int calendarField, int offsite){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(calendarField, offsite);
        return cal.getTime();
    }
    //endregion

    //region Date Compare
    /**
     * 比较日期大小
     * @param dateStr0
     * @param dateStr1
     * @return
     */
    public static int compareDate(String dateStr0, String dateStr1) {
        Date date1 = parseDateTime(dateStr0);
        Date date2 = parseDateTime(dateStr1);
        int result = date1.compareTo(date2);
        return result;
    }

    /**
     * 计算日期差
     * @param date1
     * @param date2
     * @param field
     * 		yyyy:年
     * 		MM:月
     * 		dd:日
     * @return
     * 		date2 - date1
     */
    public static int dateDiff(Date date1, Date date2, String field) {
        boolean flag = date1.compareTo(date2) > 0;
        if (flag) {
            Date tmp = date1;
            date1 = date2;
            date2 = tmp;
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        int year1 = cal1.get(Calendar.YEAR);
        int month1 = cal1.get(Calendar.MONTH);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int year2 = cal2.get(Calendar.YEAR);
        int month2 = cal2.get(Calendar.MONTH);
        int yearDiff = year2- year1;

        int diff = 0;
        if ("yyyy".equals(field)) {
            diff = yearDiff;
        } else if ("MM".equals(field)) {
            if (yearDiff <= 0) {
                diff = month2 - month1;
            } else if (yearDiff == 1) {
                diff = 12 - month1 + month2;
            } else {
                diff = 12 - month1 + (year2 - year1 - 1) * 12 + month2;
            }
        } else if ("dd".equals(field)) {
            if (yearDiff <= 0) {
                diff = cal2.get(Calendar.DAY_OF_YEAR) - cal1.get(Calendar.DAY_OF_YEAR);
            } else if (yearDiff == 1) {
                diff = getDaysLeftOfYear(date1) + cal2.get(Calendar.DAY_OF_YEAR);
            } else {
                diff = getDaysLeftOfYear(date1);
                Calendar cal;
                for (int i = 1; i < yearDiff; i++) {
                    cal = Calendar.getInstance();
                    cal.setTime(dateAdd(date1, "yyyy", i));
                    diff += cal.getActualMaximum(Calendar.DAY_OF_YEAR);
                }
                diff += cal2.get(Calendar.DAY_OF_YEAR);
            }
        }

        return flag ? -1 * diff : diff;
    }

    /**
     * 计算日期差
     * @param dateStr1
     * @param dateStr2
     * @param field
     * 		yyyy:年
     * 		MM:月
     * 		dd:日
     * @return
     */
    public static int dateDiff(String dateStr1, String dateStr2, String field) {
        Date date1 = parseDate(dateStr1);
        Date date2 = parseDate(dateStr2);
        int dateDiff = dateDiff(date1, date2, field);
        return dateDiff;
    }

    /**
     * 在原日期加一段时间间隔
     * @param date
     * 		原日期
     * @param field
     * 		"yyyy":年
     * 		"MM":月
     * 		"dd":日
     * @param amount
     * 		间隔长度
     * @return
     */
    public static Date dateAdd(Date date, String field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if ("yyyy".equals(field)) {
            calendar.add(Calendar.YEAR, amount);
        } else if ("MM".equals(field)) {
            calendar.add(Calendar.MONTH, amount);
        } else if ("dd".equals(field)) {
            calendar.add(Calendar.DATE, amount);
        }
        return calendar.getTime();
    }

    /**
     * 在原日期加一段时间间隔
     * @param dateStr
     * 		原日期
     * @param field
     * 		"yyyy":年
     * 		"MM":月
     * 		"dd":日
     * @param amount
     * 		间隔长度
     * @return
     */
    public static String dateAdd(String dateStr, String field, int amount) {
        if (dateStr == null || dateStr.isEmpty()) {
            return "";
        }

        Date date = parseDateTime(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if ("yyyy".equals(field)) {
            calendar.add(Calendar.YEAR, amount);
        } else if ("MM".equals(field)) {
            calendar.add(Calendar.MONTH, amount);
        } else if ("dd".equals(field)) {
            calendar.add(Calendar.DATE, amount);
        }
        date = calendar.getTime();
        dateStr = formatDateTime(date);
        return dateStr;
    }
    //endregion

    //region Date Position
    /**
     * 计算给定日期当年总天数
     * @param date
     * @return
     */
    public static int getDaysOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    /**
     * 计算给定日期当年剩余天数
     * @param date
     * @return
     */
    public static int getDaysLeftOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int cnt = cal.getActualMaximum(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
        return cnt;
    }

    /**
     * 计算给定日期所在月的第一天
     * @param date
     * 		给定日期
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 计算给定日期所在月的最后一天
     * @param date
     * 		给定日期
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 计算给定日期所在周的第一天(周一)
     * @param date
     * 		给定日期
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        dayOfWeek = dayOfWeek == Calendar.SUNDAY ? 8 : dayOfWeek;
        int dValue = Calendar.MONDAY - dayOfWeek;
        calendar.add(Calendar.DAY_OF_WEEK, dValue);
        return calendar.getTime();
    }

    /**
     * 计算给定日期所在月的最后一天(周日)
     * @param date
     * 		给定日期
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        dayOfWeek = dayOfWeek == Calendar.SUNDAY ? 8 : dayOfWeek;
        int diff = 8 - dayOfWeek;
        calendar.add(Calendar.DAY_OF_WEEK, diff);
        return calendar.getTime();
    }
    //endregion

    //region Month View
    /**
     * 计算月视图中展示的第一天
     * @param date
     * 		给定日期
     * @return
     */
    public static Date getFirstDayOfMonthView(Date date) {
        Date firstDayOfMonth = getFirstDayOfMonth(date);
        int dayOfWeek = getDay(firstDayOfMonth);
        int diff = Calendar.SUNDAY - dayOfWeek;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDayOfMonth);
        calendar.add(Calendar.DAY_OF_WEEK, diff);
        return calendar.getTime();
    }

    /**
     * 计算月视图中展示的最后一天
     * @param date
     * 		给定日期
     * @return
     */
    public static Date getLastDayOfMonthView(Date date) {
        Date lastDayOfMonth = getLastDayOfMonth(date);
        int dayOfWeek = getDay(lastDayOfMonth);
        int diff = Calendar.SATURDAY - dayOfWeek;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastDayOfMonth);
        calendar.add(Calendar.DAY_OF_WEEK, diff);
        return calendar.getTime();
    }

    /**
     * 计算月视图展示行数
     * @param date
     * @return
     */
    public static int getRowCntOfMonthView(Date date) {
        int dayOfWeek1 = getDay(getFirstDayOfMonth(date));
        int dayOfWeek2 = getDay(getLastDayOfMonth(date));

        if (dayOfWeek1 == Calendar.SUNDAY && dayOfWeek2 == Calendar.SATURDAY) {
            return 4;
        }
        if (dayOfWeek1 != Calendar.SUNDAY && dayOfWeek2 != Calendar.SATURDAY) {
            return 6;
        }
        return 5;
    }
    //endregion

    //region Calculate Code Spend Time
    /**
     * 计时，常用于记录某段代码的执行时间，单位：纳秒
     * @param preTime 之前记录的时间
     * @return 时间差，纳秒
     */
    public static long spendNt(long preTime) {
        return System.nanoTime() - preTime;
    }

    /**
     * 计时，常用于记录某段代码的执行时间，单位：毫秒
     * @param preTime 之前记录的时间
     * @return 时间差，毫秒
     */
    public static long spendMs(long preTime) {
        return System.currentTimeMillis() - preTime;
    }
    //endregion
}
