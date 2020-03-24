package com.enjin.sdk.models.identity;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.identity.IdentitiesService;

/**
 * A builder for creating a new identity on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
public class CreateIdentity extends GraphQLRequest<CreateIdentity> {

    public CreateIdentity appId(Integer appId) {
        set("appId", appId);
        return this;
    }

    /**
     * The user id to create the new identity for.
     *
     * @param userId the users id.
     *
     * @return the builder.
     */
    public CreateIdentity userId(int userId) {
        set("user_id", userId);
        return this;
    }

    /**
     * The user email to create the new identity for.
     *
     * @param email the users email.
     *
     * @return the builder.
     */
    public CreateIdentity email(String email) {
        set("email", email);
        return this;
    }

    /**
     * The ethereum address to assign to the created identity.
     *
     * @param ethereumAddress the ethereum address.
     *
     * @return the builder.
     */
    public CreateIdentity ethAddr(String ethereumAddress) {
        set("ethAddress", ethereumAddress);
        return this;
    }

}
