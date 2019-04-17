package com.enjin.enjincoin.sdk.http;

public interface Callback<T> {

    void onComplete(Result<T> result);

}