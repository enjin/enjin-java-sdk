package com.enjin.enjincoin.sdk.client.service.identity.impl;

import com.enjin.enjincoin.sdk.client.service.identity.vo.LinkIdentityRequestBody;
import com.enjin.enjincoin.sdk.client.service.identity.vo.LinkIdentityResponseBody;
import com.enjin.enjincoin.sdk.client.service.identity.IdentityService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class IdentityServiceImpl implements IdentityService {

    private RetrofitIdentityService service;

    public IdentityServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(RetrofitIdentityService.class);
    }

    @Override
    public void linkIdentityAsync(String linkingCode, LinkIdentityRequestBody request, Callback<LinkIdentityResponseBody> callback) {
        Call<LinkIdentityResponseBody> call = this.service.linkIdentity(linkingCode, request);
        call.enqueue(callback);
    }


    @Override
    public Response<LinkIdentityResponseBody> linkIdentitySync(String linkingCode, LinkIdentityRequestBody request) throws IOException {
        Call<LinkIdentityResponseBody> call = this.service.linkIdentity(linkingCode, request);
        return call.execute();
    }

}
