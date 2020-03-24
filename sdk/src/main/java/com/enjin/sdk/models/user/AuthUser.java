package com.enjin.sdk.models.user;

import com.enjin.sdk.graphql.GraphQLRequest;

public class AuthUser extends GraphQLRequest<AuthUser> {

    public AuthUser id(String id) {
        set("id", id);
        return this;
    }

}
