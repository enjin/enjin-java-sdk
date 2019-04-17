package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class CompleteTradeData {

    @SerializedName("trade_id")
    private String tradeId;

}
