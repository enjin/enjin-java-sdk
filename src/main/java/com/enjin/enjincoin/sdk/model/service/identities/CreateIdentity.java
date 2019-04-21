package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class CreateIdentity extends GraphQLRequest.Builder {

    public CreateIdentity withUserId(BigInteger userId) {
        withParameter("user_id", userId);
        return this;
    }

    public CreateIdentity withEmail(String email) {
        withParameter("email", email);
        return this;
    }

    public CreateIdentity withEthereumAddress(String ethereumAddress) {
        withParameter("ethereum_address", ethereumAddress);
        return this;
    }

    public CreateIdentity withFields(List<IdentityFieldInput> fields) {
        withParameter("fields", fields);
        return this;
    }

    public CreateIdentity withFields(IdentityFieldInput... fields) {
        withParameter("fields", Arrays.asList(fields));
        return this;
    }

}
