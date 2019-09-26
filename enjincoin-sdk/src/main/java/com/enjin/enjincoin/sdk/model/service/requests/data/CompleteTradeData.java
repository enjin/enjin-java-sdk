package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Complete Trade request type.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.requests.RequestsService
 */
@Builder
public class CompleteTradeData {

    /**
     * The trade id from the CreateTrade event.
     *
     * -- SETTER --
     *
     * @param tradeId the trade id.
     * @return the builder.
     */
    @SerializedName("trade_id")
    private String tradeId;

}
