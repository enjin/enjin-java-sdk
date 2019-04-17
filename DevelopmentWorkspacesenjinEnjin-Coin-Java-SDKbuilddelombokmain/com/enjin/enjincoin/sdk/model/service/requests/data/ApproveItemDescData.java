package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class ApproveItemDescData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    @SerializedName("current_value")
    private Integer currentValue;
    private Integer value;

    ApproveItemDescData(final String tokenId, final String tokenIndex, final Integer currentValue, final Integer value) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.currentValue = currentValue;
        this.value = value;
    }


    public static class ApproveItemDescDataBuilder {
        private String tokenId;
        private String tokenIndex;
        private Integer currentValue;
        private Integer value;

        ApproveItemDescDataBuilder() {
        }

        public ApproveItemDescDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public ApproveItemDescDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public ApproveItemDescDataBuilder currentValue(final Integer currentValue) {
            this.currentValue = currentValue;
            return this;
        }

        public ApproveItemDescDataBuilder value(final Integer value) {
            this.value = value;
            return this;
        }

        public ApproveItemDescData build() {
            return new ApproveItemDescData(tokenId, tokenIndex, currentValue, value);
        }

        @Override
        public String toString() {
            return "ApproveItemDescData.ApproveItemDescDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", currentValue=" + this.currentValue + ", value=" + this.value + ")";
        }
    }

    public static ApproveItemDescDataBuilder builder() {
        return new ApproveItemDescDataBuilder();
    }
}
