package io.enjincoin.sdk.client.service.identities.impl;

import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.IdentityFilter;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityResponseBody;
import io.enjincoin.sdk.client.vo.identity.GetIdentityResponseVO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;

public class IdentitiesServiceImpl implements IdentitiesService {

    private RetrofitIdentitiesService service;

    public IdentitiesServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(RetrofitIdentitiesService.class);
    }

    @Override
    public void getIdentitiesAsync(Callback<GetIdentityResponseVO[]> callback) {
        Call<GetIdentityResponseVO[]> call = this.service.getIdentities();
        call.enqueue(callback);
    }

    @Override
    public Response<GetIdentityResponseVO[]> getIdentitiesSync() throws IOException {
        Call<GetIdentityResponseVO[]> call = this.service.getIdentities();
        return call.execute();
    }

    @Override
    public void getIdentitiesAsync(Map<String, Object> filter, Callback<GetIdentityResponseVO[]> callback) {
        Call<GetIdentityResponseVO[]> call = this.service.getIdentities(new IdentityFilter(filter));
        call.enqueue(callback);
    }

    @Override
    public Response<GetIdentityResponseVO[]> getIdentitiesSync(Map<String, Object> filter) throws IOException {
        Call<GetIdentityResponseVO[]> call = this.service.getIdentities(new IdentityFilter(filter));
        return call.execute();
    }

    @Override
    public void getIdentityAsync(int id, Callback<GetIdentityResponseVO> callback) {
        Call<GetIdentityResponseVO> call = this.service.getIdentity(id);
        call.enqueue(callback);
    }

    @Override
    public Response<GetIdentityResponseVO> getIdentitySync(int id) throws IOException {
        Call<GetIdentityResponseVO> call = this.service.getIdentity(id);
        return call.execute();
    }

    @Override
    public void createIdentityAsync(Callback<CreateIdentityResponseBody> callback) {
        Call<CreateIdentityResponseBody> call = this.service.createIdentity(new CreateIdentityRequestBody());
        call.enqueue(callback);
    }

    @Override
    public Response<CreateIdentityResponseBody> createIdentitySync() throws IOException {
        Call<CreateIdentityResponseBody> call = this.service.createIdentity(new CreateIdentityRequestBody());
        return call.execute();
    }

    @Override
    public void createIdentityAsync(CreateIdentityRequestBody request, Callback<CreateIdentityResponseBody> callback) {
        Call<CreateIdentityResponseBody> call = this.service.createIdentity(request);
        call.enqueue(callback);
    }

    @Override
    public Response<CreateIdentityResponseBody> createIdentitySync(CreateIdentityRequestBody request) throws IOException {
        Call<CreateIdentityResponseBody> call = this.service.createIdentity(request);
        return call.execute();
    }

}
