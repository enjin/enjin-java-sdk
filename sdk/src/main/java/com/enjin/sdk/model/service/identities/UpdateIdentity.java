package com.enjin.sdk.model.service.identities;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.service.identities.IdentitiesService;

/**
 * A builder for updating an identity on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
public class UpdateIdentity extends GraphQLRequest<UpdateIdentity> {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     *
     * @return the builder.
     */
    public UpdateIdentity identityId(int identityId) {
        withParameter("id", identityId);
        return this;
    }

    public UpdateIdentity linkingCode(String linkingCode) {
        withParameter("linkingCode", linkingCode);
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
        withParameter("ethAddress", ethAddr);
        return this;
    }

}
