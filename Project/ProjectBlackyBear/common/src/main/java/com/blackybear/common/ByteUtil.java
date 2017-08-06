package com.blackybear.common;

import java.nio.charset.Charset;

/**
 * Description: Byte Utility
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class ByteUtil {
    /**
     * Transform short type to byte array
     * @param data
     * @return
     */
    public static byte[] getBytes(short data) {
        boolean isLittleEndian = false;
        return getBytes(data, isLittleEndian);
    }

    /**
     * Transform short type to byte array
     * @param data
     * @param isLittleEndian
     * @return
     */
    public static byte[] getBytes(short data, boolean isLittleEndian) {
        byte[] bytes = new byte[2];
        if (isLittleEndian) {
            bytes[0] = (byte) (data & 0xFF);
            bytes[1] = (byte) ((data >> 8) & 0xFF);
            return bytes;
        }
        bytes[0] = (byte) ((data >> 8) & 0xFF);
        bytes[1] = (byte) (data & 0xFF);
        return bytes;
    }

    /**
     * Transform integer type to byte array
     * @param data
     * @return
     */
    public static byte[] getBytes(int data) {
        boolean isLittleEndian = false;
        return getBytes(data, isLittleEndian);
    }

    /**
     * Transform integer type to byte array
     * @param data
     * @param isLittleEndian
     * @return
     */
    public static byte[] getBytes(int data, boolean isLittleEndian) {
        byte[] bytes = new byte[4];
        if (isLittleEndian) {
            bytes[0] = (byte) (data & 0xFF);
            bytes[1] = (byte) ((data >> 8) & 0xFF);
            bytes[2] = (byte) ((data >> 16 & 0xFF));
            bytes[3] = (byte) ((data >> 24 & 0xFF));
            return bytes;
        }
        bytes[0] = (byte) ((data >> 24) & 0xFF);
        bytes[1] = (byte) ((data >> 16) & 0xFF);
        bytes[2] = (byte) ((data >> 8 & 0xFF));
        bytes[3] = (byte) (data & 0xFF);
        return bytes;
    }

    /**
     * Transform long type to byte array
     * @param data
     * @return
     */
    public static byte[] getBytes(long data) {
        boolean isLittleEndian = false;
        return getBytes(data, isLittleEndian);
    }

    /**
     * Transform long type to byte array
     * @param data
     * @param isLittleEndian
     * @return
     */
    public static byte[] getBytes(long data, boolean isLittleEndian) {
        byte[] bytes = new byte[8];
        if (isLittleEndian) {
            bytes[0] = (byte) (data & 0xFF);
            bytes[1] = (byte) ((data >> 8) & 0xFF);
            bytes[2] = (byte) ((data >> 16) & 0xFF);
            bytes[3] = (byte) ((data >> 24) & 0xFF);
            bytes[4] = (byte) ((data >> 32) & 0xFF);
            bytes[5] = (byte) ((data >> 40) & 0xFF);
            bytes[6] = (byte) ((data >> 48) & 0xFF);
            bytes[7] = (byte) ((data >> 56) & 0xFF);
            return bytes;
        }
        bytes[0] = (byte) ((data >> 56) & 0xFF);
        bytes[1] = (byte) ((data >> 48) & 0xFF);
        bytes[2] = (byte) ((data >> 40) & 0xFF);
        bytes[3] = (byte) ((data >> 32) & 0xFF);
        bytes[4] = (byte) ((data >> 24) & 0xFF);
        bytes[5] = (byte) ((data >> 16) & 0xFF);
        bytes[6] = (byte) ((data >> 8) & 0xFF);
        bytes[7] = (byte) (data & 0xFF);
        return bytes;
    }

    /**
     * Transform float type to byte array
     * @param data
     * @return
     */
    public static byte[] getBytes(float data) {
        int bits = Float.floatToIntBits(data);
        return getBytes(bits);
    }

    /**
     * Transform float type to byte array
     * @param data
     * @param isLittleEndian
     * @return
     */
    public static byte[] getBytes(float data, boolean isLittleEndian) {
        int bits = Float.floatToIntBits(data);
        return getBytes(bits, isLittleEndian);
    }

    /**
     * Transform double type to byte array
     * @param data
     * @return
     */
    public static byte[] getBytes(double data) {
        long bits = Double.doubleToLongBits(data);
        return getBytes(bits);
    }

    /**
     * Transform double type to byte array
     * @param data
     * @param isLittleEndian
     * @return
     */
    public static byte[] getBytes(double data, boolean isLittleEndian) {
        long bits = Double.doubleToLongBits(data);
        return getBytes(bits, isLittleEndian);
    }

    /**
     * Transform character type to byte array
     * @param data
     * @return
     */
    public static byte[] getBytes(char data) {
        boolean isLittleEndian = false;
        return getBytes(data, isLittleEndian);
    }

    /**
     * Transform character type to byte array
     * @param data
     * @param isLittleEndian
     * @return
     */
    public static byte[] getBytes(char data, boolean isLittleEndian) {
        byte[] bytes = new byte[2];
        if (isLittleEndian) {
            bytes[0] = (byte) (data & 0xFF);
            bytes[1] = (byte) ((data >> 8) & 0xFF);
            return bytes;
        }
        bytes[0] = (byte) ((data >> 8) & 0xFF);
        bytes[1] = (byte) (data & 0xFF);
        return bytes;
    }

    /**
     * Transform string type to byte array
     * @param data
     * @param charsetName
     * @return
     */
    public static byte[] getBytes(String data, String charsetName) {
        Charset charset = Charset.forName(charsetName);
        return data.getBytes(charset);
    }

    /**
     * Transform byte array to short type
     * @param btyes
     * @return
     */
    public static short getShort(byte[] btyes) {
        boolean isLittleEndian = false;
        return getShort(btyes, isLittleEndian);
    }

    /**
     * Transform byte array to short type
     * @param bytes
     * @param isLittleEndian
     * @return
     */
    public static short getShort(byte[] bytes, boolean isLittleEndian) {
        return isLittleEndian ? (short) ((bytes[0] & 0xFF) | ((bytes[1] << 8) & 0xFF00))
                : (short) ((bytes[1] & 0xFF) | ((bytes[0] << 8) & 0xFF00));
    }

    /**
     * Transform byte array to character type
     * @param bytes
     * @return
     */
    public static char getChar(byte[] bytes) {
        boolean isLittleEndian = false;
        return getChar(bytes, isLittleEndian);
    }

    /**
     * Transform byte array to character type
     * @param bytes
     * @param isLittleEndian
     * @return
     */
    public static char getChar(byte[] bytes, boolean isLittleEndian) {
        return isLittleEndian ? (char) ((bytes[0] & 0xFF) | ((bytes[1] << 8) & 0xFF00))
                : (char) ((bytes[1] & 0xFF) | ((bytes[0] << 8) & 0xFF00));
    }

    /**
     * Transform byte array to integer type
     * @param bytes
     * @return
     */
    public static int getInt(byte[] bytes) {
        boolean isLittleEndian = false;
        return getInt(bytes, isLittleEndian);
    }

    /**
     * Transform byte array to integer type
     * @param bytes
     * @param isLittleEndian
     * @return
     */
    public static int getInt(byte[] bytes, boolean isLittleEndian) {
        return isLittleEndian
                ? (int)((bytes[0] & 0xFF) | ((bytes[1] << 8) & 0xFF00) | ((bytes[2] << 16) & 0xFF0000) | ((bytes[3] << 24) & 0xFF000000))
                :  (int)((bytes[3] & 0xFF) | ((bytes[2] << 8) & 0xFF00) | ((bytes[1] << 16) & 0xFF0000) | ((bytes[0] << 24) & 0xFF000000));
    }

    /**
     * Transform byte array to long type
     * @param bytes
     * @return
     */
    public static long getLong(byte[] bytes) {
        boolean isLittleEndian = false;
        return getLong(bytes, isLittleEndian);
    }

    /**
     * Transform byte array to long type
     * @param bytes
     * @param isLittleEndian
     * @return
     */
    public static long getLong(byte[] bytes, boolean isLittleEndian) {
        return isLittleEndian
                ? (long)((bytes[0] & 0xFFL) | ((bytes[1] << 8) & 0xFF00L) |
                ((bytes[2] << 16) & 0xFF0000L) | ((bytes[3] << 24) & 0xFF000000L) |
                ((bytes[4] << 32) & 0xFF00000000L) | ((bytes[5] << 40) & 0xFF0000000000L) |
                ((bytes[6] << 48) & 0xFF000000000000L) | ((bytes[7] << 56) & 0xFF00000000000000L))
                :  (long)((bytes[7] & 0xFFL) | ((bytes[6] << 8) & 0xFF00L) |
                ((bytes[5] << 16) & 0xFF0000L) | ((bytes[4] << 24) & 0xFF000000L) |
                ((bytes[3] << 32) & 0xFF00000000L) | ((bytes[2] << 40) & 0xFF0000000000L) |
                ((bytes[1] << 48) & 0xFF000000000000L) | ((bytes[0] << 56) & 0xFF00000000000000L));
    }

    /**
     * Transform byte array to float type
     * @param bytes
     * @return
     */
    public static float getFloat(byte[] bytes) {
        return Float.intBitsToFloat(getInt(bytes));
    }

    /**
     * Transform byte array to float type
     * @param bytes
     * @param isLittleEndian
     * @return
     */
    public static float getFloat(byte[] bytes, boolean isLittleEndian) {
        return Float.intBitsToFloat(getInt(bytes, isLittleEndian));
    }

    /**
     * Transform byte array to double type
     * @param bytes
     * @return
     */
    public static double getDouble(byte[] bytes) {
        return Double.longBitsToDouble(getLong(bytes));
    }

    /**
     * Transform byte array to double type
     * @param bytes
     * @param isLittleEndian
     * @return
     */
    public static double getDouble(byte[] bytes, boolean isLittleEndian) {
        return Double.longBitsToDouble(getLong(bytes, isLittleEndian));
    }

    /**
     * Transform byte array to string type
     * @param bytes
     * @param mCharsetName
     * @return
     */
    public static String getString(byte[] bytes, String mCharsetName) {
        return new String(bytes, Charset.forName(mCharsetName));
    }
}

