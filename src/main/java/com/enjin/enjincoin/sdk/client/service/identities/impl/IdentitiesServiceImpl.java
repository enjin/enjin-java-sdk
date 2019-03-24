package com.enjin.enjincoin.sdk.client.service.identities.impl;

import com.enjin.enjincoin.sdk.client.Callback;
import com.enjin.enjincoin.sdk.client.Response;
import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.ServiceBase;
import com.enjin.enjincoin.sdk.client.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.client.service.identities.vo.Identity;
import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityField;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.UpdateIdentityData;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class IdentitiesServiceImpl extends ServiceBase implements IdentitiesService {

    private IdentitiesRetrofitService service;

    public IdentitiesServiceImpl(final Retrofit retrofit) {
        this.service = retrofit.create(IdentitiesRetrofitService.class);
    }

    @Override
    public void getAllIdentitiesAsync(final Callback<GraphQLResponse<IdentitiesData>> callback) {
        enqueue(getAllIdentitiesCall(), callback);
    }

    @Override
    public void getIdentitiesAsync(final Integer identityId,
                                   final String ethereumAddress,
                                   final Callback<GraphQLResponse<IdentitiesData>> callback) {
        enqueue(getIdentitiesCall(identityId, ethereumAddress), callback);
    }

    @Override
    public void createIdentityAsync(final Integer userId,
                                    final String ethereumAddress,
                                    final List<IdentityField> fields,
                                    final Callback<GraphQLResponse<CreateIdentityData>> callback) {
        enqueue(getCreateIdentityCall(userId, ethereumAddress, fields), callback);
    }

    @Override
    public void unlinkIdentityAsync(final Integer identityId,
                                    final Boolean unlink,
                                    final Callback<GraphQLResponse<Identity>> callback) {
        enqueue(getUnlinkIdentityCall(identityId, unlink), callback);
    }

    @Override
    public void updateIdentityAsync(final Integer identityId,
                                    final Integer appId,
                                    final Integer userId,
                                    final String ethereumAddress,
                                    final List<IdentityField> fields,
                                    final Callback<GraphQLResponse<UpdateIdentityData>> callback) {
        enqueue(getUpdateIdentityCall(identityId,
                                      appId,
                                      userId,
                                      ethereumAddress,
                                      fields),
                callback);
    }

    @Override
    public Response<GraphQLResponse<IdentitiesData>> getAllIdentitiesSync() throws IOException {
        return execute(getAllIdentitiesCall());
    }

    @Override
    public Response<GraphQLResponse<IdentitiesData>> getIdentitiesSync(final Integer identityId,
                                                                       final String ethereumAddress) throws IOException {
        return execute(getIdentitiesCall(identityId, ethereumAddress));
    }

    @Override
    public Response<GraphQLResponse<CreateIdentityData>> createIdentitySync(final Integer userId,
                                                                            final String ethereumAddress,
                                                                            final List<IdentityField> fields) throws IOException {
        return execute(getCreateIdentityCall(userId, ethereumAddress, fields));
    }

    public Response<GraphQLResponse<Identity>> unlinkIdentitySync(final Integer identityId,
                                                                  final Boolean unlink) throws IOException {
        return execute(getUnlinkIdentityCall(identityId, unlink));
    }

    @Override
    public Response<GraphQLResponse<UpdateIdentityData>> updateIdentitySync(final Integer identityId,
                                                                            final Integer appId,
                                                                            final Integer userId,
                                                                            final String ethereumAddress,
                                                                            final List<IdentityField> fields) throws IOException {
        return execute(getUpdateIdentityCall(identityId,
                                             appId,
                                             userId,
                                             ethereumAddress,
                                             fields));
    }

    private Call<GraphQLResponse<IdentitiesData>> getAllIdentitiesCall() {
        return this.service.getAllIdentities(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<IdentitiesData>> getIdentitiesCall(final Integer id, final String ethereumAddress) {
        return this.service.getIdentities(GraphQLRequest.builder()
                                                        .withParameter("id", id)
                                                        .withParameter("ethereum_address", ethereumAddress));
    }

    private Call<GraphQLResponse<CreateIdentityData>> getCreateIdentityCall(final Integer userId,
                                                                            final String ethereumAddress,
                                                                            final List<IdentityField> fields) {
        return this.service.createIdentity(GraphQLRequest.builder()
                                                         .withParameter("user_id", userId)
                                                         .withParameter("ethereum_address", ethereumAddress)
                                                         .withParameter("fields", fields));
    }

    private Call<GraphQLResponse<Identity>> getUnlinkIdentityCall(final Integer identityId, final Boolean unlink) {
        return this.service.unlinkIdentity(GraphQLRequest.builder()
                                                         .withParameter("id", identityId)
                                                         .withParameter("unlink", unlink));
    }

    private Call<GraphQLResponse<UpdateIdentityData>> getUpdateIdentityCall(final Integer id,
                                                                            final Integer appId,
                                                                            final Integer userId,
                                                                            final String ethereumAddress,
                                                                            final List<IdentityField> fields) {
        return this.service.updateIdentity(GraphQLRequest.builder()
                                                         .withParameter("id", id)
                                                         .withParameter("app_id", appId)
                                                         .withParameter("user_id", userId)
                                                         .withParameter("ethereum_address", ethereumAddress)
                                                         .withParameter("fields", fields));
    }

}
