package com.enjin.enjincoin.sdk.service.identities;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentityResult;
import com.enjin.enjincoin.sdk.model.service.identities.DeleteIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.DeleteIdentityResult;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentities;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentitiesResult;
import com.enjin.enjincoin.sdk.model.service.identities.Identity;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentityResult;
import com.enjin.enjincoin.sdk.http.Callback;

public interface AsynchronousIdentitiesService {

    /**
     * @param callback
     */
    void getAllIdentitiesAsync(Callback<GraphQLResponse<GetIdentitiesResult>> callback);

    /**
     * @param query
     * @param callback
     */
    void getIdentitiesAsync(GetIdentities query,
                            Callback<GraphQLResponse<GetIdentitiesResult>> callback);

    /**
     * @param query
     * @param callback
     */
    void createIdentityAsync(CreateIdentity query,
                             Callback<GraphQLResponse<CreateIdentityResult>> callback);

    /**
     * @param query
     * @param callback
     */
    void deleteIdentityAsync(DeleteIdentity query,
                             Callback<GraphQLResponse<DeleteIdentityResult>> callback);

    /**
     * @param query
     * @param callback
     */
    void updateIdentityAsync(UpdateIdentity query,
                             Callback<GraphQLResponse<UpdateIdentityResult>> callback);
}
