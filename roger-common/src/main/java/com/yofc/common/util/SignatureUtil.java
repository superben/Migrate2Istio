package com.yofc.common.util;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignatureUtil {

    private static final String TOKEN = "rogerstoken";

    public static String getToken(String nonce, String key){
        String sortString = sort(TOKEN, nonce, key);
        //加密
        return sha1(sortString);
    }

    public static String validate(String signature, String nonce, String key){
        String sortString = sort(TOKEN, nonce, key);
        //加密
        String myString = sha1(sortString);
        if(!StringUtils.isEmpty(myString) && myString.equals(signature)){
            return signature;
        }
        return "";
}

    private static String sort(String token, String nonce, String key) {
        String[] strArray = {token, nonce, key};
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }

        return sb.toString();
    }

    private static String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
