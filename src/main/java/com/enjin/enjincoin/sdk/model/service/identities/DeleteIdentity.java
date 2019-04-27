package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

import java.math.BigInteger;

/**
 * A builder for deleting an identity from the Trusted platform.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.identities.IdentitiesService
 */
public class DeleteIdentity extends GraphQLRequest.Builder {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     * @return the builder.
     */
    public DeleteIdentity withIdentityId(BigInteger identityId) {
        withParameter("id", identityId);
        return this;
    }

    /**
     * Whether to unlink or delete an identity.
     *
     * @param unlink to unlink or not to unlink.
     * @return the builder.
     */
    public DeleteIdentity withUnlink(boolean unlink) {
        withParameter("unlink", unlink);
        return this;
    }

    /**
     * Unlinks an ethereum address from an identity.
     *
     * <p>Sets the identity id and unlink to true.
     *
     * @param id the identity id.
     * @return the builder.
     */
    public static DeleteIdentity unlink(BigInteger id) {
        return new DeleteIdentity().withIdentityId(id)
                                   .withUnlink(true);
    }

}
