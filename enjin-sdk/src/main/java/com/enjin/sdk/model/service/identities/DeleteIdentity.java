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

    /**
     * Whether to unlink or delete an identity.
     *
     * @return the builder.
     */
    public DeleteIdentity unlink() {
        withParameter("unlink", true);
        return this;
    }

    /**
     * Unlinks an ethereum address from an identity.
     *
     * <p>Sets the identity id and unlink to true.
     *
     * @param id the identity id.
     *
     * @return the builder.
     */
    public static DeleteIdentity unlink(int id) {
        return new DeleteIdentity().identityId(id)
                                   .unlink();
    }

}
