package com.bs.yuyue.vo;

public class RetResult<T> extends RetResponse {
    public int code;

    private String message;

    private T data;
    private String Token;

    public String getToken() {
        return Token;
    }

    public RetResult<T> setToken(String token) {
        this.Token = token;
        return this;
    }

    public int getCode() {
        return code;
    }

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RetResult<T> setMessage(String msg) {
        this.message = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }

}

