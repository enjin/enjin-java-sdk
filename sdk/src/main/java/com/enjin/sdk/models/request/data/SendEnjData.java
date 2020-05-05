package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
import lombok.Builder;

/**
 * A data model for the Send ENJ request type.
 *
 * @see RequestsService
 */
@Builder
public class SendEnjData {

    /**
     * The wallet's Ethereum address to send ENJ to.
     *
     * @param to the Ethereum address
     * @return   the builder
     */
    private String to;

    /**
     * The amount of ENJ to send in Wei (10^18 value, e.g. 1 ENJ = 1000000000000000000).
     *
     * @param value the amount
     * @return      the builder
     */
    private String value;

}
