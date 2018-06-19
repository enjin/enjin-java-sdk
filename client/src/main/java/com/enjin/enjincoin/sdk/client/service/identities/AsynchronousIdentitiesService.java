package com.enjin.enjincoin.sdk.client.service.identities;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityField;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.UpdateIdentityData;
import retrofit2.Callback;

import java.util.List;

public interface AsynchronousIdentitiesService {

    void getAllIdentitiesAsync(Callback<GraphQLResponse<IdentitiesData>> callback);

    void getIdentitiesAsync(Integer id, String ethereumAddress, Callback<GraphQLResponse<IdentitiesData>> callback);

    void createIdentityAsync(Integer userId, String ethereumAddress, List<IdentityField> fields, Callback<GraphQLResponse<CreateIdentityData>> callback);

    void updateIdentityAsync(Integer id, Integer appId, Integer userId,
                             String ethereumAddress,
                             List<IdentityField> fields, Callback<GraphQLResponse<UpdateIdentityData>> callback);
}
