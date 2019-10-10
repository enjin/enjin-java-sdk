package com.enjin.sdk.http;

import java.util.logging.Level;

import lombok.extern.java.Log;
import retrofit2.Call;
import retrofit2.Callback;

@Log
public abstract class SimpleCallback<T> implements Callback<T> {

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        SimpleCallback.log.log(Level.WARNING, "Exception encountered", t);
    }

}
