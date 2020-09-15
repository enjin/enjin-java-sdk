package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for getting the platform details.
 *
 * @see com.enjin.sdk.models.Platform
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class GetPlatform extends GraphQLRequest<GetPlatform> {

    /**
     * Sole constructor.
     */
    public GetPlatform() {
        super("enjin.sdk.shared.GetPlatform");
    }

    /**
     * Sets the request to include the contracts with the platform.
     *
     * @return this request for chaining
     */
    public GetPlatform withContracts() {
        return set("withContracts", true);
    }

    /**
     * Sets the request to include the notification drivers with the platform.
     *
     * @return this request for chaining
     */
    public GetPlatform withNotificationDrivers() {
        return set("withNotificationDrivers", true);
    }

}
