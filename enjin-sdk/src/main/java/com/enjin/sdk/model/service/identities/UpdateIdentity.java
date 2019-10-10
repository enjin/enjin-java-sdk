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

    /**
     * The new app id to transfer an identity to.
     *
     * @param appId the new app id.
     *
     * @return the builder.
     */
    public UpdateIdentity appId(int appId) {
        withParameter("app_id", appId);
        return this;
    }

    /**
     * The user id to link this identity to.
     *
     * @param userId the user id.
     *
     * @return the builder.
     */
    public UpdateIdentity userId(int userId) {
        withParameter("user_id", userId);
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
        withParameter("ethereum_address", ethAddr);
        return this;
    }

}
