package com.blackybear.common;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: RSA Utility
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
@SuppressWarnings("Duplicates")
public class RSAUtil {
    public final static String RSA_PUBLICKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnX/W8da3NrfqADwQE8UwVOCg2t3QpbtxR1rN8sux0+qSRLHjBtwuqk8BttNGUA7dQTMKJrXA5Z3tu6WkyX03EdYGDEZziiw6Lgjx3CUgWzL8qtubZTQQ0LUFqbzUF39BkD/DJ/Nw3kmPLVnXnwyhdvKFHwWBaxfOdkJHNDe9CraeNXtsDTqFoi1j24peYJXJL5bH44vE0xmezGGfUUxc/R7O8DsygKq0Jc07z66AV5EusjJuocEe9P7Y5UJkUGFRzpqz5A4m0O50+qKQF6wllq11PopQBy3GykpgD8YFyQoK1b59YTqQ//gHeU2HejcF98GPiPE8vJQIlYCgym/HSwIDAQAB";
    public final static String RSA_PRIVATEKEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCdf9bx1rc2t+oAPBATxTBU4KDa3dClu3FHWs3yy7HT6pJEseMG3C6qTwG200ZQDt1BMwomtcDlne27paTJfTcR1gYMRnOKLDouCPHcJSBbMvyq25tlNBDQtQWpvNQXf0GQP8Mn83DeSY8tWdefDKF28oUfBYFrF852Qkc0N70Ktp41e2wNOoWiLWPbil5glckvlsfji8TTGZ7MYZ9RTFz9Hs7wOzKAqrQlzTvProBXkS6yMm6hwR70/tjlQmRQYVHOmrPkDibQ7nT6opAXrCWWrXU+ilAHLcbKSmAPxgXJCgrVvn1hOpD/+Ad5TYd6NwX3wY+I8Ty8lAiVgKDKb8dLAgMBAAECggEBAJTGlPE/hTQACOAN3JYAWAZlZi05CQX1CS2BHjgyqBlpZJ/VdYIebUpddV4RN0Mat3AGWZl1aPC9/TqbXw0h5epIRNBFoJCt9ItV0bnFrEnZ4Qk4hxLTWur7hIzxHVvQzssHID9V25Fu5PvO+Tp5wPBOaOeD2Nuj0lithPtTh5Rcr7xVSen+2iA1NR8zBRnrxzrvVGXljO/EWOxubYRqtx7d2v+ouM1V0UgbOO1K2r5Lhy80lCr6EYYW5I0x2mbAAMInvmXM3H2Cs/wsnuAYsMHmfHUGD+hn1XAKjGGKt6hspRUr+pQ0MovyusF7XAOb55ANdWS39YJFdzIB5jkzTzkCgYEAyRBqRtRbG1SaSi6HwErjT4Uuip3pnlqvrRIbCKLzrcuqVFqQWeQqvHyOn4ZpfTTPyJQX2qU/OKNZJQyXlJtdq2+HCzDMAD+uH1R7pcW3qDzSc8Gs75BPu7swkaOZS6ba0tuG6L6iVdm21EGVx3YF7ZraL/NuYkEEluKSq1de6icCgYEAyIhBLvOBTyerb058hvLHnSwGGK/H7SRtEVBAQO3nbjFyYxC/6csBnN5CpXbciAAQWMlk/oUmseu0KBqfX/3AWdkkiWcLgacVpPz4AUe2vz9mwS249DXQGp3DKLTvC4sXCKE1xkgx+Mt7IszFl8Bwv4WNllmwew6Y1EXRGzZHpD0CgYAhK7Ac11Pggmih7GNA+hneOJ6hB8RO968b4mzLU/bXqU4EdJxz+AyE5Bezgb1NhrTw5l25GKIBehFu51Dql2cwrUmeMwK018ymJo3vn1rZSo99wWoCa9B7rDorDM5xiKl5N/Zd13V4rF5ZTiijq3j25iEw3/xKAWf8bIy978Ac6QKBgHiFS4fIWcMU+HfhF/6TE11nBBL6MpJX/iUVskhTs3AKz9CyVGVS2RlKi4uesFQclbaG8+f0ZpkwLAqeVYL/owdc9hSOld/KZ7vNPdCnJTI0DLG1pR9A6F3Wy2A/vhuV8LYDDaqp4T7CLLNxlp/pzNmOjtX5+ZM75qZNf6t3J/+RAoGBAIM97RylgN9eQbmrrhNji9NUch/bul6rLOmVXZP/2/Mh3NTnIqwwu1DhAGbPOvNpMfHYxbgrqQveQZ6R7c3Y+bDb1VYgf9gfzWH48I7yBnk8t8Kcd5d2HpNjUOsIHg49orSnV5yRw89x1MPdQVxg//F+KW8p7xUTSEPSX27lXjBo";

    // 非对称加密密钥算法
    public static final String RSA = "RSA";
    //加密填充方式
    public static final String ECB_PKCS1_PADDING = "RSA/ECB/PKCS1Padding";
    //秘钥默认长度
    public static final int DEFAULT_KEY_SIZE = 2048;
    // 当要加密的内容超过bufferSize，则采用partSplit进行分块加密
    public static final byte[] DEFAULT_SPLIT = "#PART#".getBytes();
    public static final int DEFAULT_BUFFERSIZE = (DEFAULT_KEY_SIZE / 8) - 11;// 当前秘钥支持加密的最大字节数

    //获取公钥私钥对
    public static KeyPair generateRSAKeyPair() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(DEFAULT_KEY_SIZE);
            return kpg.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    //公钥加密
    public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {
        // 得到公钥
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
        KeyFactory kf = KeyFactory.getInstance(RSA);
        PublicKey keyPublic = kf.generatePublic(keySpec);
        // 加密数据
        Cipher cp = Cipher.getInstance(ECB_PKCS1_PADDING);
        cp.init(Cipher.ENCRYPT_MODE, keyPublic);
        return cp.doFinal(data);
    }

    //公钥解密
    public static byte[] decryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {
        // 得到公钥
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
        KeyFactory kf = KeyFactory.getInstance(RSA);
        PublicKey keyPublic = kf.generatePublic(keySpec);
        // 数据解密
        Cipher cipher = Cipher.getInstance(ECB_PKCS1_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, keyPublic);
        return cipher.doFinal(data);
    }

    //私钥加密
    public static byte[] encryptByPrivateKey(byte[] data, byte[] privateKey) throws Exception {
        // 得到私钥
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory kf = KeyFactory.getInstance(RSA);
        PrivateKey keyPrivate = kf.generatePrivate(keySpec);
        // 数据加密
        Cipher cipher = Cipher.getInstance(ECB_PKCS1_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, keyPrivate);
        return cipher.doFinal(data);
    }

    //私钥解密
    public static byte[] decryptByPrivateKey(byte[] encrypted, byte[] privateKey) throws Exception {
        // 得到私钥
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory kf = KeyFactory.getInstance(RSA);
        PrivateKey keyPrivate = kf.generatePrivate(keySpec);

        // 解密数据
        Cipher cp = Cipher.getInstance(ECB_PKCS1_PADDING);
        cp.init(Cipher.DECRYPT_MODE, keyPrivate);
        byte[] arr = cp.doFinal(encrypted);
        return arr;
    }

    //公钥分段加密
    public static byte[] encryptByPublicKeyForSpilt(byte[] data, byte[] publicKey) throws Exception {
        int dataLen = data.length;
        if (dataLen <= DEFAULT_BUFFERSIZE) {
            return encryptByPublicKey(data, publicKey);
        }
        List<Byte> allBytes = new ArrayList<Byte>(2048);
        int bufIndex = 0;
        int subDataLoop = 0;
        byte[] buf = new byte[DEFAULT_BUFFERSIZE];
        for (int i = 0; i < dataLen; i++) {
            buf[bufIndex] = data[i];
            if (++bufIndex == DEFAULT_BUFFERSIZE || i == dataLen - 1) {
                subDataLoop++;
                if (subDataLoop != 1) {
                    for (byte b : DEFAULT_SPLIT) {
                        allBytes.add(b);
                    }
                }
                byte[] encryptBytes = encryptByPublicKey(buf, publicKey);
                for (byte b : encryptBytes) {
                    allBytes.add(b);
                }
                bufIndex = 0;
                if (i == dataLen - 1) {
                    buf = null;
                } else {
                    buf = new byte[Math.min(DEFAULT_BUFFERSIZE, dataLen - i - 1)];
                }
            }
        }
        byte[] bytes = new byte[allBytes.size()];
        {
            int i = 0;
            for (Byte b : allBytes) {
                bytes[i++] = b.byteValue();
            }
        }
        return bytes;
    }

    //公钥分段解密
    public static byte[] decryptByPublicKeyForSpilt(byte[] encrypted, byte[] publicKey) throws Exception {
        int splitLen = DEFAULT_SPLIT.length;
        if (splitLen <= 0) {
            return decryptByPublicKey(encrypted, publicKey);
        }
        int dataLen = encrypted.length;
        List<Byte> allBytes = new ArrayList<Byte>(1024);
        int latestStartIndex = 0;
        for (int i = 0; i < dataLen; i++) {
            byte bt = encrypted[i];
            boolean isMatchSplit = false;
            if (i == dataLen - 1) {
                // 到data的最后了
                byte[] part = new byte[dataLen - latestStartIndex];
                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
                byte[] decryptPart = decryptByPublicKey(part, publicKey);
                for (byte b : decryptPart) {
                    allBytes.add(b);
                }
                latestStartIndex = i + splitLen;
                i = latestStartIndex - 1;
            } else if (bt == DEFAULT_SPLIT[0]) {
                // 这个是以split[0]开头
                if (splitLen > 1) {
                    if (i + splitLen < dataLen) {
                        // 没有超出data的范围
                        for (int j = 1; j < splitLen; j++) {
                            if (DEFAULT_SPLIT[j] != encrypted[i + j]) {
                                break;
                            }
                            if (j == splitLen - 1) {
                                // 验证到split的最后一位，都没有break，则表明已经确认是split段
                                isMatchSplit = true;
                            }
                        }
                    }
                } else {
                    // split只有一位，则已经匹配了
                    isMatchSplit = true;
                }
            }
            if (isMatchSplit) {
                byte[] part = new byte[i - latestStartIndex];
                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
                byte[] decryptPart = decryptByPublicKey(part, publicKey);
                for (byte b : decryptPart) {
                    allBytes.add(b);
                }
                latestStartIndex = i + splitLen;
                i = latestStartIndex - 1;
            }
        }
        byte[] bytes = new byte[allBytes.size()];
        {
            int i = 0;
            for (Byte b : allBytes) {
                bytes[i++] = b.byteValue();
            }
        }
        return bytes;
    }

    //私钥分段加密
    public static byte[] encryptByPrivateKeyForSpilt(byte[] data, byte[] privateKey) throws Exception {
        int dataLen = data.length;
        if (dataLen <= DEFAULT_BUFFERSIZE) {
            return encryptByPrivateKey(data, privateKey);
        }
        List<Byte> allBytes = new ArrayList<Byte>(2048);
        int bufIndex = 0;
        int subDataLoop = 0;
        byte[] buf = new byte[DEFAULT_BUFFERSIZE];
        for (int i = 0; i < dataLen; i++) {
            buf[bufIndex] = data[i];
            if (++bufIndex == DEFAULT_BUFFERSIZE || i == dataLen - 1) {
                subDataLoop++;
                if (subDataLoop != 1) {
                    for (byte b : DEFAULT_SPLIT) {
                        allBytes.add(b);
                    }
                }
                byte[] encryptBytes = encryptByPrivateKey(buf, privateKey);
                for (byte b : encryptBytes) {
                    allBytes.add(b);
                }
                bufIndex = 0;
                if (i == dataLen - 1) {
                    buf = null;
                } else {
                    buf = new byte[Math.min(DEFAULT_BUFFERSIZE, dataLen - i - 1)];
                }
            }
        }
        byte[] bytes = new byte[allBytes.size()];
        {
            int i = 0;
            for (Byte b : allBytes) {
                bytes[i++] = b.byteValue();
            }
        }
        return bytes;
    }

    //私钥分段解密
    public static byte[] decryptByPrivateKeyForSpilt(byte[] encrypted, byte[] privateKey) throws Exception {
        int splitLen = DEFAULT_SPLIT.length;
        if (splitLen <= 0) {
            return decryptByPrivateKey(encrypted, privateKey);
        }
        int dataLen = encrypted.length;
        List<Byte> allBytes = new ArrayList<Byte>(2048);
        int latestStartIndex = 0;
        for (int i = 0; i < dataLen; i++) {
            byte bt = encrypted[i];
            boolean isMatchSplit = false;
            if (i == dataLen - 1) {
                // 到data的最后了
                byte[] part = new byte[dataLen - latestStartIndex];
                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
                byte[] decryptPart = decryptByPrivateKey(part, privateKey);
                for (byte b : decryptPart) {
                    allBytes.add(b);
                }
                latestStartIndex = i + splitLen;
                i = latestStartIndex - 1;
            } else if (bt == DEFAULT_SPLIT[0]) {
                // 这个是以split[0]开头
                if (splitLen > 1) {
                    if (i + splitLen < dataLen) {
                        // 没有超出data的范围
                        for (int j = 1; j < splitLen; j++) {
                            if (DEFAULT_SPLIT[j] != encrypted[i + j]) {
                                break;
                            }
                            if (j == splitLen - 1) {
                                // 验证到split的最后一位，都没有break，则表明已经确认是split段
                                isMatchSplit = true;
                            }
                        }
                    }
                } else {
                    // split只有一位，则已经匹配了
                    isMatchSplit = true;
                }
            }
            if (isMatchSplit) {
                byte[] part = new byte[i - latestStartIndex];
                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
                byte[] decryptPart = decryptByPrivateKey(part, privateKey);
                for (byte b : decryptPart) {
                    allBytes.add(b);
                }
                latestStartIndex = i + splitLen;
                i = latestStartIndex - 1;
            }
        }
        byte[] bytes = new byte[allBytes.size()];
        {
            int i = 0;
            for (Byte b : allBytes) {
                bytes[i++] = b.byteValue();
            }
        }
        return bytes;
    }


    //公钥加密（字符串）
    public static String encryptByPublicKey(String data, String publicKey) throws Exception {
        byte[] encryptData = encryptByPublicKey(data.getBytes("UTF-8"), Base64.decodeBase64(publicKey));
        return Base64.encodeBase64String(encryptData);
    }

    // 公钥解密（字符串）
    public static String decryptByPublicKey(String encrypted, String publicKey) throws Exception {
        byte[] data = decryptByPublicKey(Base64.decodeBase64(encrypted), Base64.decodeBase64(publicKey));
        return new String(data, "UTF-8");
    }

    //私钥加密（字符串）
    public static String encryptByPrivateKey(String data, String privateKey) throws Exception {
        byte[] encryptData = encryptByPrivateKey(data.getBytes("UTF-8"), Base64.decodeBase64(privateKey));
        return Base64.encodeBase64String(encryptData);
    }

    //私钥解密（字符串）
    public static String decryptByPrivateKey(String encrypted, String privateKey) throws Exception {
        byte[] data = decryptByPrivateKey(Base64.decodeBase64(encrypted), Base64.decodeBase64(privateKey));
        return new String(data, "UTF-8");
    }

    //公钥分段加密（字符串）
    public static String encryptByPublicKeyForSpilt(String data, String publicKey) throws Exception {
        byte[] encryptData = encryptByPublicKeyForSpilt(data.getBytes("UTF-8"), Base64.decodeBase64(publicKey));
        return Base64.encodeBase64String(encryptData);
    }

    // 公钥分段解密（字符串）
    public static String decryptByPublicKeyForSpilt(String encrypted, String publicKey) throws Exception {
        byte[] data = decryptByPublicKeyForSpilt(Base64.decodeBase64(encrypted), Base64.decodeBase64(publicKey));
        return new String(data, "UTF-8");
    }

    //私钥分段加密（字符串）
    public static String encryptByPrivateKeyForSpilt(String data, String privateKey) throws Exception {
        byte[] encryptData = encryptByPrivateKeyForSpilt(data.getBytes("UTF-8"), Base64.decodeBase64(privateKey));
        return Base64.encodeBase64String(encryptData);
    }

    //私钥分段解密（字符串）
    public static String decryptByPrivateKeyForSpilt(String encrypted, String privateKey) throws Exception {
        byte[] data = decryptByPrivateKeyForSpilt(Base64.decodeBase64(encrypted), Base64.decodeBase64(privateKey));
        return new String(data, "UTF-8");
    }

    public static void main(String[] args) throws Exception {
        KeyPair keyPair = generateRSAKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        String publicKeyStr = Base64.encodeBase64String(publicKey.getEncoded());
        String privateKeyStr = Base64.encodeBase64String(privateKey.getEncoded());
        System.out.println("公钥\r\n" + publicKeyStr);
        System.out.println("私钥\r\n" + privateKeyStr);

//        String content = "jMjuq7Q6KLJvlnGb";
//        byte[] contentByte = content.getBytes("UTF-8");
//        String publicKeyStr = "";
//        String privateKeyStr = "";
//        byte[] publicKey = Base64.decode(publicKeyStr.getBytes());
//        byte[] privateKey = Base64.decode(privateKeyStr.getBytes());
//        // 公钥加密
//        byte[] publicEncryptContentByte = encryptByPublicKeyForSpilt(contentByte, publicKey);
//        String publicEncryptContentStr = new String(publicEncryptContentByte);
//        System.out.println("公钥加密：" + publicEncryptContentStr);
//        // 私钥解密
//        byte[] privateEncryptContentByte = decryptByPrivateKeyForSpilt(publicEncryptContentByte, privateKey);
//        String privateEncryptContentStr = new String(privateEncryptContentByte);
//        System.out.println("私钥解密：" + privateEncryptContentStr);
    }
}
