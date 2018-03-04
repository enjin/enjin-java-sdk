package io.enjincoin.sdk.client.service.identities.impl;

import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.identities.vo.*;
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
    public void getIdentitiesAsync(Callback<GetIdentityResponseBody[]> callback) {
        Call<GetIdentityResponseBody[]> call = this.service.getIdentities();
        call.enqueue(callback);
    }

    @Override
    public void getIdentitiesAsync(Map<String, Object> filter, Callback<GetIdentityResponseBody[]> callback) {
        Call<GetIdentityResponseBody[]> call = this.service.getIdentities(new IdentityFilter(filter));
        call.enqueue(callback);
    }

    @Override
    public void getIdentityAsync(long id, Callback<GetIdentityResponseBody> callback) {
        Call<GetIdentityResponseBody> call = this.service.getIdentity(id);
        call.enqueue(callback);
    }

    @Override
    public void createIdentityAsync(Callback<CreateIdentityResponseBody> callback) {
        Call<CreateIdentityResponseBody> call = this.service.createIdentity(new CreateIdentityRequestBody());
        call.enqueue(callback);
    }

    @Override
    public void createIdentityAsync(CreateIdentityRequestBody request, Callback<CreateIdentityResponseBody> callback) {
        Call<CreateIdentityResponseBody> call = this.service.createIdentity(request);
        call.enqueue(callback);
    }

    @Override
    public void updateIdentityAsync(long id, UpdateIdentityRequestBody request, Callback<UpdateIdentityResponseBody> callback) {
        Call<UpdateIdentityResponseBody> call = this.service.updateIdentity(id, request);
        call.enqueue(callback);
    }

    @Override
    public void deleteIdentityAsync(long id, Callback<Boolean> callback) {
        Call<Boolean> call = this.service.deleteIdentity(id);
        call.enqueue(callback);
    }

    @Override
    public void linkIdentityAsync(String linkingCode, LinkIdentityRequestBody request, Callback<LinkIdentityResponseBody> callback) {
        Call<LinkIdentityResponseBody> call = this.service.linkIdentity(linkingCode, request);
        call.enqueue(callback);
    }

    @Override
    public Response<GetIdentityResponseBody[]> getIdentitiesSync() throws IOException {
        Call<GetIdentityResponseBody[]> call = this.service.getIdentities();
        return call.execute();
    }

    @Override
    public Response<GetIdentityResponseBody[]> getIdentitiesSync(Map<String, Object> filter) throws IOException {
        Call<GetIdentityResponseBody[]> call = this.service.getIdentities(new IdentityFilter(filter));
        return call.execute();
    }

    @Override
    public Response<GetIdentityResponseBody> getIdentitySync(long id) throws IOException {
        Call<GetIdentityResponseBody> call = this.service.getIdentity(id);
        return call.execute();
    }

    @Override
    public Response<CreateIdentityResponseBody> createIdentitySync() throws IOException {
        Call<CreateIdentityResponseBody> call = this.service.createIdentity(new CreateIdentityRequestBody());
        return call.execute();
    }

    @Override
    public Response<CreateIdentityResponseBody> createIdentitySync(CreateIdentityRequestBody request) throws IOException {
        Call<CreateIdentityResponseBody> call = this.service.createIdentity(request);
        return call.execute();
    }

    @Override
    public Response<UpdateIdentityResponseBody> updateIdentitySync(long id, UpdateIdentityRequestBody request) throws IOException {
        Call<UpdateIdentityResponseBody> call = this.service.updateIdentity(id, request);
        return call.execute();
    }

    @Override
    public Response<Boolean> deleteIdentitySync(long id) throws IOException {
        Call<Boolean> call = this.service.deleteIdentity(id);
        return call.execute();
    }

    @Override
    public Response<LinkIdentityResponseBody> linkIdentitySync(String linkingCode, LinkIdentityRequestBody request) throws IOException {
        Call<LinkIdentityResponseBody> call = this.service.linkIdentity(linkingCode, request);
        return call.execute();
    }

}
