package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

import java.util.Arrays;
import java.util.List;

public class UpdateIdentity extends GraphQLRequest.Builder {

    public UpdateIdentity withIdentityId(int identityId) {
        withParameter("id", identityId);
        return this;
    }

    public UpdateIdentity withAppId(int appId) {
        withParameter("app_id", appId);
        return this;
    }

    public UpdateIdentity withUserId(int userId) {
        withParameter("user_id", userId);
        return this;
    }

    public UpdateIdentity withEthereumAddress(String ethereumAddress) {
        withParameter("ethereum_address", ethereumAddress);
        return this;
    }

    public UpdateIdentity withFields(List<IdentityFieldInput> fields) {
        withParameter("fields", fields);
        return this;
    }

    public UpdateIdentity withFields(IdentityFieldInput... fields) {
        withParameter("fields", Arrays.asList(fields));
        return this;
    }

}
