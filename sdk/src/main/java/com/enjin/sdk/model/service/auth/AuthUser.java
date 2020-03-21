package com.enjin.sdk.model.service.auth;

import com.enjin.sdk.graphql.GraphQLRequest;

public class AuthUser extends GraphQLRequest<AuthUser> {

    public AuthUser id(String id) {
        withVariable("id", id);
        return this;
    }

}
