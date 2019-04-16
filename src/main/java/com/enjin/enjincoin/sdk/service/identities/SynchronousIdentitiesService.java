package com.enjin.enjincoin.sdk.service.identities;

import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.query.CreateIdentity;
import com.enjin.enjincoin.sdk.model.query.GetIdentities;
import com.enjin.enjincoin.sdk.model.query.UnlinkIdentity;
import com.enjin.enjincoin.sdk.model.query.UpdateIdentity;
import com.enjin.enjincoin.sdk.service.identities.vo.Identity;
import com.enjin.enjincoin.sdk.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.service.identities.vo.data.UpdateIdentityData;

import java.io.IOException;

public interface SynchronousIdentitiesService {

    /**
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<IdentitiesData>> getAllIdentitiesSync() throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<IdentitiesData>> getIdentitiesSync(GetIdentities query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<CreateIdentityData>> createIdentitySync(CreateIdentity query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<Identity>> unlinkIdentitySync(UnlinkIdentity query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<UpdateIdentityData>> updateIdentitySync(UpdateIdentity query) throws IOException;
}
