package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * A builder for updating an identity on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.identities.IdentitiesService
 */
public class UpdateIdentity extends GraphQLRequest.Builder {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     * @return the builder.
     */
    public UpdateIdentity withIdentityId(BigInteger identityId) {
        withParameter("id", identityId);
        return this;
    }

    /**
     * The new app id to transfer an identity to.
     *
     * @param appId the new app id.
     * @return the builder.
     */
    public UpdateIdentity withAppId(int appId) {
        withParameter("app_id", appId);
        return this;
    }

    /**
     * The user id to link this identity to.
     *
     * @param userId the user id.
     * @return the builder.
     */
    public UpdateIdentity withUserId(BigInteger userId) {
        withParameter("user_id", userId);
        return this;
    }

    /**
     * The ethereum address linked to the identity.
     *
     * @param ethAddr the ethereum address.
     * @return the builder.
     */
    public UpdateIdentity withEthereumAddress(String ethAddr) {
        withParameter("ethereum_address", ethAddr);
        return this;
    }

    /**
     * The fields to add and/or modify for an identity.
     *
     * @param fields the fields.
     * @return the builder.
     */
    public UpdateIdentity withFields(List<IdentityFieldInput> fields) {
        withParameter("fields", fields);
        return this;
    }

    /**
     * The fields to add and/or modify for an identity.
     *
     * @param fields the fields.
     * @return the builder.
     */
    public UpdateIdentity withFields(IdentityFieldInput... fields) {
        withParameter("fields", Arrays.asList(fields));
        return this;
    }

}
