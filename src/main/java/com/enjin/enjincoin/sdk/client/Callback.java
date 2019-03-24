package com.enjin.enjincoin.sdk.client;

public interface Callback<T> {

    void onComplete(Response<T> response);

}