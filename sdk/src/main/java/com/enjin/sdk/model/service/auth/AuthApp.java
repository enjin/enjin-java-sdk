package com.enjin.sdk.model.service.auth;

import com.enjin.sdk.graphql.GraphQLRequest;

public class AuthApp extends GraphQLRequest<AuthApp> {

    public AuthApp id(Integer appId) {
        withVariable("id", appId);
        return this;
    }

    public AuthApp secret(String secret) {
        withVariable("secret", secret);
        return this;
    }

}
