package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class DecreaseMaxTransferFeeData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    private String maxTransferFee;

    DecreaseMaxTransferFeeData(final String tokenId, final String tokenIndex, final String maxTransferFee) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.maxTransferFee = maxTransferFee;
    }


    public static class DecreaseMaxTransferFeeDataBuilder {
        private String tokenId;
        private String tokenIndex;
        private String maxTransferFee;

        DecreaseMaxTransferFeeDataBuilder() {
        }

        public DecreaseMaxTransferFeeDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public DecreaseMaxTransferFeeDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public DecreaseMaxTransferFeeDataBuilder maxTransferFee(final String maxTransferFee) {
            this.maxTransferFee = maxTransferFee;
            return this;
        }

        public DecreaseMaxTransferFeeData build() {
            return new DecreaseMaxTransferFeeData(tokenId, tokenIndex, maxTransferFee);
        }

        @Override
        public String toString() {
            return "DecreaseMaxTransferFeeData.DecreaseMaxTransferFeeDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", maxTransferFee=" + this.maxTransferFee + ")";
        }
    }

    public static DecreaseMaxTransferFeeDataBuilder builder() {
        return new DecreaseMaxTransferFeeDataBuilder();
    }
}
