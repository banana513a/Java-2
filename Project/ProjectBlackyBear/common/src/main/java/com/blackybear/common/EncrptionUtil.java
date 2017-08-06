package com.blackybear.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Description: Encrption Utility
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class EncrptionUtil {
    /**
     * Get salt by ASCII code
     * @param size
     * @return
     */
    public static String getSaltByAscii(int size) {
        char[] randomChar = new char[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            randomChar[i] = ((char) (random.nextInt(93) + 33));
        }
        return new String(randomChar);
    }

    /**
     * Get MD5 code
     * @param data
     * @param salt
     * @return
     */
    public static String MD5(String data, String salt) {
        String result = null;
        data = salt != null ? new StringBuilder().append(data).append(salt).toString() : data;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = messageDigest.digest(data.getBytes("utf8"));
            result = bytes2hex(bytes);
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        } catch (UnsupportedEncodingException exception1) {
            exception1.printStackTrace();
        }
        return result;
    }

    /**
     * Get SHA1 code
     * @param data
     * @param salt
     * @return
     */
    public static String SHA1(String data, String salt) {
        String result = null;
        data = salt != null ? new StringBuilder().append(data).append(salt).toString() : data;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = messageDigest.digest(data.getBytes("utf8"));
            result = bytes2hex(bytes);
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        } catch (UnsupportedEncodingException exception1) {
            exception1.printStackTrace();
        }
        return result;
    }

    /**
     * Transform byte array to hex string
     * @param bytes
     * @return
     */
    public static String bytes2hex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        String temp = null;
        for (byte b : bytes) {
            temp = Integer.toHexString(b & 0xFF);
            if (temp.length() == 1)
                hex.append("0");
            hex.append(temp.toLowerCase());
        }
        return hex.toString();
    }

    /**
     * Transform hex string to byte array
     * @param hex
     * @return
     */
    public static byte[] hex2bytes(String hex) {
        int len = hex.length();
        byte[] bytes = new byte[len / 2];
        String sub = null;
        for (int i = 0; i < len; i += 2) {
            sub = hex.substring(i, i + 2);
            int intb = Integer.parseInt(sub, 16);
            bytes[(i / 2)] = ((byte) (intb & 0xFF));
        }
        return bytes;
    }
}
