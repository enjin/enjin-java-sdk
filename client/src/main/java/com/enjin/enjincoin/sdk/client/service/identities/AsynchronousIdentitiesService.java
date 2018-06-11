package com.enjin.enjincoin.sdk.client.service.identities;

import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityField;
import retrofit2.Callback;

import java.util.List;

public interface AsynchronousIdentitiesService {

    void getAllIdentitiesAsync(Callback<GraphQLResponse> callback);

    void getIdentitiesAsync(Integer id, String ethereumAddress, Callback<GraphQLResponse> callback);

    void createIdentityAsync(Integer id, String ethereumAddress, List<IdentityField> fields, Callback<GraphQLResponse> callback);

    void updateIdentityAsync(Integer id, Integer appId, Integer userId,
                             String ethereumAddress,
                             List<IdentityField> fields, Callback<GraphQLResponse> callback);
}
