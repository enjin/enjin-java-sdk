package com.enjin.enjincoin.sdk.service.identities;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.service.identities.vo.Identity;
import com.enjin.enjincoin.sdk.service.identities.vo.IdentityField;
import com.enjin.enjincoin.sdk.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.service.identities.vo.data.UpdateIdentityData;

import java.util.List;

public interface AsynchronousIdentitiesService {

    /**
     * @param callback
     */
    void getAllIdentitiesAsync(Callback<GraphQLResponse<IdentitiesData>> callback);

    /**
     * @param identityId
     * @param ethereumAddress
     * @param linkingCode
     * @param callback
     */
    void getIdentitiesAsync(Integer identityId,
                            String ethereumAddress,
                            String linkingCode,
                            Callback<GraphQLResponse<IdentitiesData>> callback);

    /**
     * @param userId
     * @param email
     * @param ethereumAddress
     * @param fields
     * @param callback
     */
    void createIdentityAsync(Integer userId,
                             String email,
                             String ethereumAddress,
                             List<IdentityField> fields,
                             Callback<GraphQLResponse<CreateIdentityData>> callback);

    /**
     * @param identityId
     * @param unlink
     */
    void unlinkIdentityAsync(Integer identityId, Boolean unlink, Callback<GraphQLResponse<Identity>> callback);

    /**
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
