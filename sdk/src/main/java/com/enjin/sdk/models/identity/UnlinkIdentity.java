package com.enjin.sdk.models.identity;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.identity.IdentitiesService;

/**
 * An object class for unlinking identities on the Trusted Platform.
 *
 * @see IdentitiesService
 */
public class UnlinkIdentity extends GraphQLRequest<UnlinkIdentity> implements IdentityFragment<UnlinkIdentity> {

    /**
     * The identity id.
     *
     * @param userId the identity id
     * @return       this request
     */
    public UnlinkIdentity id(int userId) {
        set("id", userId);
        return this;
    }

}
