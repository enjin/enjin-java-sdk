package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Complete Trade request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class CompleteTradeData {

    /**
     * The trade id from the CreateTrade event.
     *
     * @param tradeId the trade id.
     * @return the builder.
     */
    @SerializedName("trade_id")
    private String tradeId;

}
