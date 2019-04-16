package com.enjin.enjincoin.sdk.model.query;

import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;

public class CreateUser extends GraphQLRequest.Builder {

    public CreateUser withName(String name) {
        withParameter("name", name);
        return this;
    }

    public CreateUser withEmail(String email) {
        withParameter("email", email);
        return this;
    }

    public CreateUser withPassword(String password) {
        withParameter("password", password);
        return this;
    }

}
