package com.example.ketangpai.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 名称
 * @date 2022/8/29 17:23
 */
public class MD5Util {

    public static String getMD5(String str) {
        String md5;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");// 生成一个MD5加密计算摘要
            md.update(str.getBytes());// 计算md5函数
            /**
             * digest()最后确定返回md5 hash值，返回值为8位字符串。
             * 因为md5 hash值是16位的hex值，实际上就是8位的字符
             * BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
             * 一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
             */
            md5 = new BigInteger(1, md.digest()).toString(16);// 16是表示转换为16进制数
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return md5;
    }

}
