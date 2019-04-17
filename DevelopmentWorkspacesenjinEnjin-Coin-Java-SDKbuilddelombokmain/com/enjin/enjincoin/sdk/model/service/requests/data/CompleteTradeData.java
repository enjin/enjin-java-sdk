package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class CompleteTradeData {
    @SerializedName("trade_id")
    private String tradeId;

    CompleteTradeData(final String tradeId) {
        this.tradeId = tradeId;
    }


    public static class CompleteTradeDataBuilder {
        private String tradeId;

        CompleteTradeDataBuilder() {
        }

        public CompleteTradeDataBuilder tradeId(final String tradeId) {
            this.tradeId = tradeId;
            return this;
        }

        public CompleteTradeData build() {
            return new CompleteTradeData(tradeId);
        }

        @Override
        public String toString() {
            return "CompleteTradeData.CompleteTradeDataBuilder(tradeId=" + this.tradeId + ")";
        }
    }

    public static CompleteTradeDataBuilder builder() {
        return new CompleteTradeDataBuilder();
    }
}
