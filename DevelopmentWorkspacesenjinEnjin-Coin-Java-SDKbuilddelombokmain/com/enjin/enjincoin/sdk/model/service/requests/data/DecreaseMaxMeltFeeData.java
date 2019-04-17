package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class DecreaseMaxMeltFeeData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    private Integer maxMeltFee;

    DecreaseMaxMeltFeeData(final String tokenId, final String tokenIndex, final Integer maxMeltFee) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.maxMeltFee = maxMeltFee;
    }


    public static class DecreaseMaxMeltFeeDataBuilder {
        private String tokenId;
        private String tokenIndex;
        private Integer maxMeltFee;

        DecreaseMaxMeltFeeDataBuilder() {
        }

        public DecreaseMaxMeltFeeDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public DecreaseMaxMeltFeeDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public DecreaseMaxMeltFeeDataBuilder maxMeltFee(final Integer maxMeltFee) {
            this.maxMeltFee = maxMeltFee;
            return this;
        }

        public DecreaseMaxMeltFeeData build() {
            return new DecreaseMaxMeltFeeData(tokenId, tokenIndex, maxMeltFee);
        }

        @Override
        public String toString() {
            return "DecreaseMaxMeltFeeData.DecreaseMaxMeltFeeDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", maxMeltFee=" + this.maxMeltFee + ")";
        }
    }

    public static DecreaseMaxMeltFeeDataBuilder builder() {
        return new DecreaseMaxMeltFeeDataBuilder();
    }
}
