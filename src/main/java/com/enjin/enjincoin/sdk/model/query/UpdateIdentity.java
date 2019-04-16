package com.enjin.enjincoin.sdk.model.query;

import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.service.identities.vo.IdentityField;

import java.util.Arrays;

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

    public UpdateIdentity withFields(IdentityField... fields) {
        withParameter("fields", Arrays.asList(fields));
        return this;
    }

}
