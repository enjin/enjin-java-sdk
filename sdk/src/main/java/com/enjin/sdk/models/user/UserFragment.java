package com.enjin.sdk.models.user;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.models.identity.IdentityFragment;
import com.enjin.sdk.services.user.UsersService;

/**
 * A fragment interface used to include information in a request on the Trusted Platform.
 *
 * @see UsersService
 * @param <T> the super type of the interface
 */
public interface UserFragment<T extends GraphQLRequest<T>>
        extends GraphQLVariableHolder<T>, IdentityFragment<T> {

    /**
     * Sets the request to include the user's access tokens in the response.
     *
     * @return this request
     */
    default T withUserAccessTokens() {
        set("withUserAccessTokens", true);
        return (T) this;
    }

    /**
     * Sets the request to include the user's identities in the response.
     *
     * @return this request
     */
    default T withUserIdentities() {
        set("withUserIdentities", true);
        return (T) this;
    }

    /**
     * Sets the request to include the user's timestamps in the response.
     *
     * @return this request
     */
    default T withUserTimestamps() {
        set("withUserTimestamps", true);
        return (T) this;
    }

}
