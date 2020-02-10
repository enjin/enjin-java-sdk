package com.enjin.sdk.model.service.identities;

import com.enjin.sdk.graphql.GraphQLRequest;

public class UnlinkIdentity extends GraphQLRequest<UnlinkIdentity> {

    public UnlinkIdentity id(int userId) {
        withParameter("id", userId);
        return this;
    }

}
