package com.enjin.sdk.model.service.auth;

import com.enjin.sdk.graphql.GraphQLRequest;
import lombok.Builder;

public class AuthUser extends GraphQLRequest<AuthUser> {

    public AuthUser id(String id) {
        withParameter("id", id);
        return this;
    }

}
