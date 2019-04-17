package com.enjin.enjincoin.sdk.service.identities;

import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentityResult;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentities;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentitiesResult;
import com.enjin.enjincoin.sdk.model.service.identities.Identity;
import com.enjin.enjincoin.sdk.model.service.identities.UnlinkIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentityResult;

import java.io.IOException;

public interface SynchronousIdentitiesService {

    /**
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<GetIdentitiesResult>> getAllIdentitiesSync() throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<GetIdentitiesResult>> getIdentitiesSync(GetIdentities query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<CreateIdentityResult>> createIdentitySync(CreateIdentity query) throws IOException;

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
    Response<GraphQLResponse<UpdateIdentityResult>> updateIdentitySync(UpdateIdentity query) throws IOException;
}
