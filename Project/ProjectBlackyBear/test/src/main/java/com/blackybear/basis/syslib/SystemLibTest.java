package com.blackybear.basis.syslib;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.ResourceBundle;

import static java.util.Locale.getDefault;

/**
 * Description: 系统库
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class SystemLibTest {
    public static void main(String[] args) {
        printMessageFormat();
        printNumberFormat();
        printDateFormat();
    }
    private static void printMessageFormat() {
        Locale locale = getDefault(Category.FORMAT);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource/message", locale);
        System.out.println(resourceBundle.getString("hello"));

        Locale arglocale = new Locale("zh","CN");
        resourceBundle =ResourceBundle.getBundle("resource/message", arglocale);
        String msg = resourceBundle.getString("msg");
        System.out.println(MessageFormat.format(msg, "Json", new Date()));
    }
    private static void printNumberFormat() {
        double number = 1234567.89;
        NumberFormat nfInteger = NumberFormat.getIntegerInstance(Locale.CHINA);
        NumberFormat nfCurrency = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat nfPercent = NumberFormat.getPercentInstance(Locale.CHINA);
        System.out.println(nfInteger.format(number));
        System.out.println(nfCurrency.format(number));
        System.out.println(nfPercent.format(number));
    }

    @SuppressWarnings("unused")
    private static void printDateFormat() {
        String dateShort = "2016-05-03";
        Date date = new Date();
        DateFormat dfShort = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);
        DateFormat dfMedium = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        DateFormat dfLong = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
        DateFormat dfFull = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);

        try {
            System.out.println(dfShort.parse(dateShort));
            System.out.println(dfMedium.parse(dateShort));
//			System.out.println(dfLong.parse(String.valueOf(date)));
//			System.out.println(dfFull.parse(String.valueOf(date)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
