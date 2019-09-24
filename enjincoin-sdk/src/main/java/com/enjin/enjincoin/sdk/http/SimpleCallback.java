package com.enjin.enjincoin.sdk.http;

import retrofit2.Call;
import retrofit2.Callback;

public abstract class SimpleCallback<T> implements Callback<T> {

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        t.printStackTrace();
    }

}
