package com.enjin.enjincoin.sdk.http;

public class Result<T> {

    private int code;
    private T   body;

    public Result(int code, T body) {
        this.code = code;
        this.body = body;
    }

    public int code() {
        return code;
    }

    public T body() {
        return body;
    }

    public boolean isSuccess() {
        return code >= 200 && code < 300;
    }

    public boolean isEmpty() {
        return this.body == null;
    }
}
