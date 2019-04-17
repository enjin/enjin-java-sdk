package com.enjin.enjincoin.sdk.model.service.users;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

public class LoginUser extends GraphQLRequest.Builder {

    public LoginUser withEmail(String email) {
        withParameter("email", email);
        return this;
    }

    public LoginUser withPassword(String password) {
        withParameter("password", password);
        return this;
    }

}
