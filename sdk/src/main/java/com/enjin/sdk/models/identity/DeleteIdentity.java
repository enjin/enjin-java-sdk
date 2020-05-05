package com.enjin.sdk.models.identity;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.identity.IdentitiesService;

/**
 * An object class for deleting an identity from the Trusted Platform.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
public class DeleteIdentity extends GraphQLRequest<DeleteIdentity> implements IdentityFragment<DeleteIdentity> {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     *
     * @return this request.
     */
    public DeleteIdentity identityId(int identityId) {
        set("id", identityId);
        return this;
    }

}
