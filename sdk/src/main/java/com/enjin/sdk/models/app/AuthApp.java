package com.enjin.sdk.models.app;

import com.enjin.sdk.graphql.GraphQLRequest;

public class AuthApp extends GraphQLRequest<AuthApp> {

    public AuthApp id(Integer appId) {
        set("id", appId);
        return this;
    }

    public AuthApp secret(String secret) {
        set("secret", secret);
        return this;
    }

}
