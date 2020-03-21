package com.enjin.sdk.model.service.apps;

import com.enjin.sdk.graphql.GraphQLRequest;

public class UnlinkApp extends GraphQLRequest<UnlinkApp> {

    public UnlinkApp appId(Integer id) {
        withVariable("id", id);
        return this;
    }

    public UnlinkApp ethAddress(String ethAddr) {
        withVariable("ethAddress", ethAddr);
        return this;
    }

}
