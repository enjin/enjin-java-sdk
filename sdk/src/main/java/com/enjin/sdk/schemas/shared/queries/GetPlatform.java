package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * TODO
 */
public class GetPlatform extends GraphQLRequest<GetPlatform> {

    /**
     * TODO
     */
    public GetPlatform() {
        super("enjin.sdk.shared.GetPlatform");
    }

    /**
     * TODO
     * @return
     */
    public GetPlatform withContracts() {
        return set("withContracts", true);
    }

    /**
     * TODO
     * @return
     */
    public GetPlatform withNotificationDrivers() {
        return set("withNotificationDrivers", true);
    }

}
