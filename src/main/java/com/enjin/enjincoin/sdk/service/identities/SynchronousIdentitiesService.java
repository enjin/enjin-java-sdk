package com.enjin.enjincoin.sdk.service.identities;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentityResult;
import com.enjin.enjincoin.sdk.model.service.identities.DeleteIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.DeleteIdentityResult;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentities;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentitiesResult;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentityResult;

import java.io.IOException;

/**
 * Synchronous methods for querying and mutating app identities.
 *
 * @author Evan Lindsay
 */
public interface SynchronousIdentitiesService {

    /**
     * Returns all identities of an app.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<GetIdentitiesResult>> getAllIdentitiesSync() throws IOException;


    /**
     * Gets identities of an app that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<GetIdentitiesResult>> getIdentitiesSync(GetIdentities query) throws IOException;

    /**
     * Creates a new identity.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<CreateIdentityResult>> createIdentitySync(CreateIdentity query) throws IOException;

    /**
     * Deletes or unlinks an identity.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<DeleteIdentityResult>> deleteIdentitySync(DeleteIdentity query) throws IOException;

    /**
     * Updates an identity.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<UpdateIdentityResult>> updateIdentitySync(UpdateIdentity query) throws IOException;
}
