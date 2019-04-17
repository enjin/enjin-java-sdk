package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

public class UnlinkIdentity extends GraphQLRequest.Builder {

    public UnlinkIdentity(int identityId) {
        super();
        withParameter("id", identityId);
        withParameter("unlink", true);
    }

}
