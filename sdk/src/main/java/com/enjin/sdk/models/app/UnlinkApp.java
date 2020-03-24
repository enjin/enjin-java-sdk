package com.enjin.sdk.models.app;

import com.enjin.sdk.graphql.GraphQLRequest;

public class UnlinkApp extends GraphQLRequest<UnlinkApp> implements AppFragment<UnlinkApp> {

    public UnlinkApp appId(Integer id) {
        set("id", id);
        return this;
    }

    public UnlinkApp ethAddress(String ethAddr) {
        set("ethAddress", ethAddr);
        return this;
    }

}
