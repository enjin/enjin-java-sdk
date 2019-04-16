package com.enjin.enjincoin.sdk.service.identities;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.query.CreateIdentity;
import com.enjin.enjincoin.sdk.model.query.GetIdentities;
import com.enjin.enjincoin.sdk.model.query.UnlinkIdentity;
import com.enjin.enjincoin.sdk.model.query.UpdateIdentity;
import com.enjin.enjincoin.sdk.service.identities.vo.Identity;
import com.enjin.enjincoin.sdk.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.service.identities.vo.data.UpdateIdentityData;

public interface AsynchronousIdentitiesService {

    /**
     * @param callback
     */
    void getAllIdentitiesAsync(Callback<GraphQLResponse<IdentitiesData>> callback);

    /**
     * @param query
     * @param callback
     */
    void getIdentitiesAsync(GetIdentities query,
                            Callback<GraphQLResponse<IdentitiesData>> callback);

    /**
     * @param query
     * @param callback
     */
    void createIdentityAsync(CreateIdentity query,
                             Callback<GraphQLResponse<CreateIdentityData>> callback);

    /**
     * @param query
     * @param callback
     */
    void unlinkIdentityAsync(UnlinkIdentity query,
                             Callback<GraphQLResponse<Identity>> callback);

    /**
     * @param query
     * @param callback
     */
    void updateIdentityAsync(UpdateIdentity query,
                             Callback<GraphQLResponse<UpdateIdentityData>> callback);
}
