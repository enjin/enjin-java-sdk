package com.enjin.sdk.models.identity;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.identity.IdentitiesService;

/**
 * An object class for creating a new identity on the Trusted Platform.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
public class CreateIdentity extends GraphQLRequest<CreateIdentity> implements IdentityFragment<CreateIdentity> {

    /**
     * The id of the application.
     *
     * @param appId the app id.
     *
     * @return this request.
     */
    public CreateIdentity appId(Integer appId) {
        set("appId", appId);
        return this;
    }

    /**
     * The user id to create the new identity for.
     *
     * @param userId the user's id.
     *
     * @return this request.
     */
    public CreateIdentity userId(int userId) {
        set("userId", userId);
        return this;
    }

    /**
     * The user email to create the new identity for.
     *
     * @param email the users email.
     *
     * @return this request.
     */
    public CreateIdentity email(String email) {
        set("email", email);
        return this;
    }

    /**
     * The Ethereum address to assign to the created identity.
     *
     * @param ethAddr the Ethereum address.
     *
     * @return this request.
     */
    public CreateIdentity ethAddr(String ethAddr) {
        set("ethAddress", ethAddr);
        return this;
    }

}
