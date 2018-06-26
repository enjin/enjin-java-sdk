package com.enjin.enjincoin.sdk.client.service.identities;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityField;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.UpdateIdentityData;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public interface SynchronousIdentitiesService {

    /**
     *
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<IdentitiesData>> getAllIdentitiesSync() throws IOException;

    /**
     *
     * @param identityId
     * @param ethereumAddress
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<IdentitiesData>> getIdentitiesSync(Integer identityId, String ethereumAddress) throws IOException;

    /**
     *
     * @param userId
     * @param ethereumAddress
     * @param fields
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<CreateIdentityData>> createIdentitySync(Integer userId, String ethereumAddress, List<IdentityField> fields) throws IOException;

    /**
     *
     * @param identityId
     * @param appId
     * @param userId
     * @param ethereumAddress
     * @param fields
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<UpdateIdentityData>> updateIdentitySync(Integer identityId, Integer appId, Integer userId,
                                                                     String ethereumAddress,
                                                                     List<IdentityField> fields) throws IOException;
}
