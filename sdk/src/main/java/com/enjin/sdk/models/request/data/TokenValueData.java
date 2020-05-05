package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
import lombok.Builder;

/**
 * A data model that defines the the type of token and how much is offered
 * in a Create Trade request.
 *
 * @author Evan Lindsay
 * @see CreateTradeData
 * @see RequestsService
 */
@Builder
public class TokenValueData {

    /**
     * The token id.
     *
     * @param id the token id.
     * @return the builder.
     */
    private String id;

    /**
     * The token index.
     *
     * @param index the token index.
     * @return the builder.
     */
    private Integer index;

    /**
     * The amount of the token.
     *
     * @param value the amount.
     * @return the builder.
     */
    private Integer value;

}
