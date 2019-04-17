package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class ApproveItemData {
    private String operator;
    @SerializedName("operator_id")
    private Integer operatorId;
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    @SerializedName("current_value")
    private Integer currentValue;
    private Integer value;

    ApproveItemData(final String operator, final Integer operatorId, final String tokenId, final String tokenIndex, final Integer currentValue, final Integer value) {
        this.operator = operator;
        this.operatorId = operatorId;
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.currentValue = currentValue;
        this.value = value;
    }


    public static class ApproveItemDataBuilder {
        private String operator;
        private Integer operatorId;
        private String tokenId;
        private String tokenIndex;
        private Integer currentValue;
        private Integer value;

        ApproveItemDataBuilder() {
        }

        public ApproveItemDataBuilder operator(final String operator) {
            this.operator = operator;
            return this;
        }

        public ApproveItemDataBuilder operatorId(final Integer operatorId) {
            this.operatorId = operatorId;
            return this;
        }

        public ApproveItemDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public ApproveItemDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public ApproveItemDataBuilder currentValue(final Integer currentValue) {
            this.currentValue = currentValue;
            return this;
        }

        public ApproveItemDataBuilder value(final Integer value) {
            this.value = value;
            return this;
        }

        public ApproveItemData build() {
            return new ApproveItemData(operator, operatorId, tokenId, tokenIndex, currentValue, value);
        }

        @Override
        public String toString() {
            return "ApproveItemData.ApproveItemDataBuilder(operator=" + this.operator + ", operatorId=" + this.operatorId + ", tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", currentValue=" + this.currentValue + ", value=" + this.value + ")";
        }
    }

    public static ApproveItemDataBuilder builder() {
        return new ApproveItemDataBuilder();
    }
}
