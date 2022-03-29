package com.bs.yuyue.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public static String md5(String password){
        //生成md5加密器

        try {
            MessageDigest md  = MessageDigest.getInstance("MD5");
            //计算md5的值
            md.update(password.getBytes());
            //BigInteger将8位的字符串 转成16位的字符串 得到的字符串形式是哈希值
            //BigInteger 中的第一个参数 sigmun 为1是正数 0为0 -1为负数
            return new BigInteger(1,md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}