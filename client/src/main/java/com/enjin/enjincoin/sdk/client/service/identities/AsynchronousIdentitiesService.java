package com.enjin.enjincoin.sdk.client.service.identities;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.identities.vo.Identity;
import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityField;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.IdentityData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.UpdateIdentityData;
import retrofit2.Callback;

import java.util.List;

public interface AsynchronousIdentitiesService {

    /**
     *
     * @param callback
     */
    void getAllIdentitiesAsync(Callback<GraphQLResponse<IdentitiesData>> callback);

    /**
     *
     * @param identityId
     * @param ethereumAddress
     * @param callback
     */
    void getIdentitiesAsync(Integer identityId, String ethereumAddress, Callback<GraphQLResponse<IdentitiesData>> callback);

    /**
     *
     * @param userId
     * @param ethereumAddress
     * @param fields
     * @param callback
     */
    void createIdentityAsync(Integer userId, String ethereumAddress, List<IdentityField> fields, Callback<GraphQLResponse<CreateIdentityData>> callback);

    /**
     *
     * @param identityId
     * @param unlink
     */
    void unlinkIdentityAsync(Integer identityId, Boolean unlink, Callback<GraphQLResponse<Identity>> callback);

    /**
     *
     * @param identityId
     * @param appId
     * @param userId
     * @param ethereumAddress
     * @param fields
     * @param callback
     */
    void updateIdentityAsync(Integer identityId, Integer appId, Integer userId,
                             String ethereumAddress,
                             List<IdentityField> fields, Callback<GraphQLResponse<UpdateIdentityData>> callback);
}
