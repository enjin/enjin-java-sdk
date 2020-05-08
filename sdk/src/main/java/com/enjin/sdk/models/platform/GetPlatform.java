package com.enjin.sdk.models.platform;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.platform.PlatformService;

/**
 * An object class for getting the platform from the Trusted Platform.
 *
 * @see PlatformService
 */
public class GetPlatform extends GraphQLRequest<GetPlatform> {

    /**
     * Sets the request to include the last scraped block on the network in the response.
     *
     * @return this request
     */
    public GetPlatform withBlockHeight() {
        set("withBlockHeight", true);
        return this;
    }

    /**
     * Sets the request to include the smart contracts used by the platform in the response.
     *
     * @return this request
     */
    public GetPlatform withContracts() {
        set("withContracts", true);
        return this;
    }

    /**
     * Sets the request to include the platform notification drivers in the response.
     *
     * @return this request
     */
    public GetPlatform withNotificationDrivers() {
        set("withNotificationDrivers", true);
        return this;
    }

}
