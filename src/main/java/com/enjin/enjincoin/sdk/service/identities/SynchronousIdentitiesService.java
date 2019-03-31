package com.enjin.enjincoin.sdk.service.identities;

import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.service.identities.vo.Identity;
import com.enjin.enjincoin.sdk.service.identities.vo.IdentityField;
import com.enjin.enjincoin.sdk.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.service.identities.vo.data.UpdateIdentityData;

import java.io.IOException;
import java.util.List;

public interface SynchronousIdentitiesService {

    /**
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<IdentitiesData>> getAllIdentitiesSync() throws IOException;

    /**
     * @param identityId
     * @param linkingCode
     * @param ethereumAddress
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<IdentitiesData>> getIdentitiesSync(Integer identityId,
                                                                String ethereumAddress,
                                                                String linkingCode) throws IOException;

    /**
     * @param userId
     * @param email
     * @param ethereumAddress
     * @param fields
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<CreateIdentityData>> createIdentitySync(Integer userId,
                                                                     String email,
                                                                     String ethereumAddress,
                                                                     List<IdentityField> fields) throws IOException;

    /**
     * @param identityId
     * @param unlink
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<Identity>> unlinkIdentitySync(Integer identityId, Boolean unlink) throws IOException;

    /**
     * @param identityId
     * @param appId
     * @param userId
     * @param ethereumAddress
     * @param fields
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<UpdateIdentityData>> updateIdentitySync(Integer identityId,
                                                                     Integer appId,
                                                                     Integer userId,
                                                                     String ethereumAddress,
                                                                     List<IdentityField> fields) throws IOException;
}
