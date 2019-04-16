package com.enjin.enjincoin.sdk.model.query;

import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.service.identities.vo.IdentityField;

import java.util.Arrays;
import java.util.List;

public class CreateIdentity extends GraphQLRequest.Builder {

    public CreateIdentity withUserId(int userId) {
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

    public CreateIdentity withFields(List<IdentityField> fields) {
        withParameter("fields", fields);
        return this;
    }

    public CreateIdentity withFields(IdentityField... fields) {
        withParameter("fields", Arrays.asList(fields));
        return this;
    }

}
