package com.enjin.enjincoin.sdk;

public interface Callback<T> {

    void onComplete(Response<T> response);

}