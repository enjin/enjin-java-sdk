package com.enjin.sdk.services.identity;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.identity.CreateIdentity;
import com.enjin.sdk.models.identity.DeleteIdentity;
import com.enjin.sdk.models.identity.GetIdentities;
import com.enjin.sdk.models.identity.GetIdentity;
import com.enjin.sdk.models.identity.Identity;
import com.enjin.sdk.models.identity.UnlinkIdentity;
import com.enjin.sdk.models.identity.UpdateIdentity;

/**
 * Synchronous methods for querying and mutating app identities.
 *
 * @author Evan Lindsay
 */
public interface SynchronousIdentitiesService {

    /**
     * Gets identities of an app that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<List<Identity>>> getIdentitiesSync(GetIdentities query);

    HttpResponse<GraphQLResponse<Identity>> getIdentitySync(GetIdentity query);

    /**
     * Creates a new identity.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<Identity>> createIdentitySync(CreateIdentity query);

    /**
     * Deletes an identity.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<Identity>> deleteIdentitySync(DeleteIdentity query);

    /**
     * Updates an identity.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<Identity>> updateIdentitySync(UpdateIdentity query);

    /**
     * Unlinks an identity.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<Identity>> unlinkIdentitySync(UnlinkIdentity query);

}
