package io.enjincoin.sdk.client.service.platform.impl;

import java.io.IOException;

import io.enjincoin.sdk.client.service.platform.PlatformService;
import io.enjincoin.sdk.client.service.platform.vo.PlatformResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PlatformServiceImpl implements PlatformService{

    private RetrofitPlatformService service;

    public PlatformServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(RetrofitPlatformService.class);
    }

    @Override
    public void getPlatformAsync(Callback<PlatformResponseBody> callback) {
        Call<PlatformResponseBody> call = this.service.getPlatform();
        call.enqueue(callback);
    }

    @Override
    public Response<PlatformResponseBody> getPlatformSync() throws IOException {
        Call<PlatformResponseBody> call = this.service.getPlatform();
        return call.execute();
    }
}
