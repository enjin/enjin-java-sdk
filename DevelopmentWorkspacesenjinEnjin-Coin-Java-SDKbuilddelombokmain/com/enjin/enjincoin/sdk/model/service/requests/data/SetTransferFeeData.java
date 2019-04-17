package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class SetTransferFeeData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    private String transferFee;

    SetTransferFeeData(final String tokenId, final String tokenIndex, final String transferFee) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.transferFee = transferFee;
    }


    public static class SetTransferFeeDataBuilder {
        private String tokenId;
        private String tokenIndex;
        private String transferFee;

        SetTransferFeeDataBuilder() {
        }

        public SetTransferFeeDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public SetTransferFeeDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public SetTransferFeeDataBuilder transferFee(final String transferFee) {
            this.transferFee = transferFee;
            return this;
        }

        public SetTransferFeeData build() {
            return new SetTransferFeeData(tokenId, tokenIndex, transferFee);
        }

        @Override
        public String toString() {
            return "SetTransferFeeData.SetTransferFeeDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", transferFee=" + this.transferFee + ")";
        }
    }

    public static SetTransferFeeDataBuilder builder() {
        return new SetTransferFeeDataBuilder();
    }
}
