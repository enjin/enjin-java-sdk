package com.enjin.enjincoin.sdk.util.concurrent;

import com.enjin.enjincoin.sdk.Response;

public interface Callback<T> {

    void onComplete(Response<T> response);

}