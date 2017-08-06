package com.blackybear.common;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;

/**
 * Description: AES Utility
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class AESUtil {
    //使用AES-128-CBC加密模式，key需要为16位
    private final static int KEYLENTH = 16;
    //偏移量
    private final static String ivParameter = "1020304050607080";

    /**
     * 生成加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位
     *
     * @return
     */
    public static String generateAESKey() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < KEYLENTH; i++) {
            int num = random.nextInt(62);
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }

    /**
     * 加密
     *
     * @param key     加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位
     * @param content
     * @return
     * @throws Exception
     */
    public static String encrypt(String key, String content) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] raw = key.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            // 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(content.getBytes("UTF-8"));
            return Base64.encodeBase64String(encrypted);// 此处使用BASE64做转码。
        } catch (Exception exception) {
            return null;
        }
    }

    /**
     * 解密
     *
     * @param key       加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位
     * @param encrypted
     * @return
     * @throws Exception
     */
    public static String decrypt(String key, String encrypted) throws Exception {
        try {
            byte[] raw = key.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = Base64.decodeBase64(encrypted);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "UTF-8");
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        // 加密
        String key = generateAESKey();
        System.out.println("加密key : " + key);
        String enString = encrypt(key, "qwe123");
        System.out.println("加密后的字串是：" + enString);
        // 解密
        String DeString = decrypt(key, enString);
        System.out.println("解密后的字串是：" + DeString);
    }
}
