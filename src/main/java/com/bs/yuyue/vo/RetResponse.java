package com.bs.yuyue.vo;

public class RetResponse {
    private final static String SUCCESS = "success";
    private final static String FAIL = "failure";

    public static <T> RetResult<T> SuccessRsp(String message) {
        return new RetResult<T>().setCode(200).setMessage(message);
    }

    public static <T> RetResult<T> SuccessRsp(T data) {
        return new RetResult<T>().setCode(200).setMessage(SUCCESS).setData(data).setToken(null);
    }

    public static <T> RetResult<T> SuccessToken(String token) {
        return new RetResult<T>().setCode(200).setMessage(SUCCESS).setToken(token);
    }

    public static <T> RetResult<T> ErrRsp(String message) {
        return new RetResult<T>().setCode(500).setMessage(message);
    }
}