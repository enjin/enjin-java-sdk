package com.enjin.sdk.services.identity;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.identity.CreateIdentity;
import com.enjin.sdk.models.identity.DeleteIdentity;
import com.enjin.sdk.models.identity.GetIdentities;
import com.enjin.sdk.models.identity.GetIdentity;
import com.enjin.sdk.models.identity.Identity;
import com.enjin.sdk.models.identity.UnlinkIdentity;
import com.enjin.sdk.models.identity.UpdateIdentity;

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

    void getIdentityAsync(GetIdentity query,
                            HttpCallback<GraphQLResponse<Identity>> callback);

    /**
     * Creates a new identity.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void createIdentityAsync(CreateIdentity query,
                             HttpCallback<GraphQLResponse<Identity>> callback);

    /**
     * Deletes an identity.
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

    /**
     * Unlinks an identity.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void unlinkIdentityAsync(UnlinkIdentity query,
                             HttpCallback<GraphQLResponse<Identity>> callback);

}
