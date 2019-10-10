package com.enjin.sdk.service.identities;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.model.service.identities.CreateIdentity;
import com.enjin.sdk.model.service.identities.DeleteIdentity;
import com.enjin.sdk.model.service.identities.GetIdentities;
import com.enjin.sdk.model.service.identities.Identity;
import com.enjin.sdk.model.service.identities.UpdateIdentity;

/**
 * Asynchronous methods for querying and mutating app identities.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousIdentitiesService {

    /**
     * Gets identities of an app that match the query parameters.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void getIdentitiesAsync(GetIdentities query,
                            HttpCallback<GraphQLResponse<List<Identity>>> callback);

    /**
     * Creates a new identity.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void createIdentityAsync(CreateIdentity query,
                             HttpCallback<GraphQLResponse<Identity>> callback);

    /**
     * Deletes or unlinks an identity.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void deleteIdentityAsync(DeleteIdentity query,
                             HttpCallback<GraphQLResponse<Identity>> callback);

    /**
     * Updates an identity.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void updateIdentityAsync(UpdateIdentity query,
                             HttpCallback<GraphQLResponse<Identity>> callback);

}
