package com.enjin.sdk.models.identity;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.identity.IdentitiesService;

/**
 * A builder for updating an identity on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
public class UpdateIdentity extends GraphQLRequest<UpdateIdentity> implements IdentityFragment<UpdateIdentity> {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     *
     * @return the builder.
     */
    public UpdateIdentity identityId(int identityId) {
        set("id", identityId);
        return this;
    }

    public UpdateIdentity linkingCode(String linkingCode) {
        set("linkingCode", linkingCode);
        return this;
    }

    /**
     * The ethereum address linked to the identity.
     *
     * @param ethAddr the ethereum address.
     *
     * @return the builder.
     */
    public UpdateIdentity ethAddr(String ethAddr) {
        set("ethAddress", ethAddr);
        return this;
    }

}
