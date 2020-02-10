package com.enjin.sdk.model.service.identities;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.service.identities.IdentitiesService;

/**
 * A builder for deleting an identity from the Trusted platform.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
public class DeleteIdentity extends GraphQLRequest<DeleteIdentity> {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     *
     * @return the builder.
     */
    public DeleteIdentity identityId(int identityId) {
        withParameter("id", identityId);
        return this;
    }

}
