package com.enjin.sdk.models.token.event;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.token.TokensService;

/**
 * An object class for getting token events from the Trusted Platform.
 *
 * @see TokensService
 */
public class GetTokenEvents extends PaginationRequest<GetTokenEvents> implements TokenEventFragment<GetTokenEvents> {

    /**
     * Sets the event id to filter by.
     *
     * @param id the event id
     * @return   this request
     */
    public GetTokenEvents id(int id) {
        set("id", id);
        return this;
    }

    /**
     * Sets the token id to filter by.
     *
     * @param tokenId the token id
     * @return        this request
     */
    public GetTokenEvents tokenId(String tokenId) {
        set("tokenId", tokenId);
        return this;
    }

    /**
     * Sets the event type to filter by.
     *
     * @param event the event type
     * @return      this request
     */
    public GetTokenEvents eventType(TokenEventType event) {
        set("event", event);
        return this;
    }

    /**
     * Sets the block number to filter by.
     *
     * @param blockNumber the block number
     * @return            this request
     */
    public GetTokenEvents blockNumber(int blockNumber) {
        set("blockNumber", blockNumber);
        return this;
    }

}
