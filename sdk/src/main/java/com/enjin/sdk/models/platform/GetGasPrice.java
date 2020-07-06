package com.enjin.sdk.models.platform;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.platform.PlatformService;
import lombok.NoArgsConstructor;

/**
 * An object class for getting the latest gas prices.
 *
 * @see PlatformService
 */
@NoArgsConstructor
public class GetGasPrice extends GraphQLRequest<GetGasPrice> {
}
