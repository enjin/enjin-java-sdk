package com.enjin.enjincoin.sdk.model.query;

import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;

public class UnlinkIdentity extends GraphQLRequest.Builder {

    public UnlinkIdentity(int identityId) {
        super();
        withParameter("id", identityId);
        withParameter("unlink", true);
    }

}
