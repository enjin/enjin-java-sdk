package com.enjin.enjincoin.sdk.http;

import lombok.extern.java.Log;
import retrofit2.Call;
import retrofit2.Callback;

import java.util.logging.Level;

@Log
public abstract class SimpleCallback<T> implements Callback<T> {

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        SimpleCallback.log.log(Level.WARNING, "Exception encountered", t);
    }

}
