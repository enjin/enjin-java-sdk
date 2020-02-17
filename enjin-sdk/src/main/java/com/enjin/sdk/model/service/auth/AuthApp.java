package com.enjin.sdk.model.service.auth;

import com.enjin.sdk.graphql.GraphQLRequest;
import lombok.Builder;

public class AuthApp extends GraphQLRequest<AuthApp> {

    public AuthApp id(Integer appId) {
        withParameter("id", appId);
        return this;
    }

    public AuthApp secret(String secret) {
        withParameter("secret", secret);
        return this;
    }

}
