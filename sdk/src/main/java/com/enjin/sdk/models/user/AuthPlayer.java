package com.enjin.sdk.models.user;

import com.enjin.sdk.graphql.GraphQLRequest;

public class AuthPlayer extends GraphQLRequest<AuthPlayer> {

    public AuthPlayer id(String id) {
        set("id", id);
        return this;
    }

}
