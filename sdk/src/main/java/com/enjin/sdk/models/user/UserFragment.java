package com.enjin.sdk.models.user;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.models.identity.IdentityFragment;

public interface UserFragment<T extends GraphQLRequest<T>>
        extends GraphQLVariableHolder<T>, IdentityFragment<T> {

    default T withUserAccessTokens() {
        set("withUserAccessTokens", true);
        return (T) this;
    }

    default T withUserIdentities() {
        set("withUserIdentities", true);
        return (T) this;
    }

    default T withUserTimestamps() {
        set("withUserTimestamps", true);
        return (T) this;
    }

}
