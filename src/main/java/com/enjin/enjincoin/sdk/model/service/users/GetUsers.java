package com.enjin.enjincoin.sdk.model.service.users;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

import java.math.BigInteger;

public class GetUsers extends GraphQLRequest.Builder {

    public GetUsers withUserId(BigInteger userId) {
        withParameter("id", userId);
        return this;
    }

    public GetUsers withName(String name) {
        withParameter("name", name);
        return this;
    }

    public GetUsers withEmail(String email) {
        withParameter("email", email);
        return this;
    }

    public GetUsers withMe(boolean me) {
        withParameter("me", me);
        return this;
    }

}
