package com.enjin.sdk.models.platform;

import com.enjin.sdk.graphql.GraphQLRequest;

public class GetPlatform extends GraphQLRequest<GetPlatform> {

    public GetPlatform withBlockHeight() {
        set("withBlockHeight", true);
        return this;
    }

    public GetPlatform withContracts() {
        set("withContracts", true);
        return this;
    }

    public GetPlatform withNotificationDrivers() {
        set("withNotificationDrivers", true);
        return this;
    }

}
