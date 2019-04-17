package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class SetMeltFeeData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    private Integer meltFee;

    SetMeltFeeData(final String tokenId, final String tokenIndex, final Integer meltFee) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.meltFee = meltFee;
    }


    public static class SetMeltFeeDataBuilder {
        private String tokenId;
        private String tokenIndex;
        private Integer meltFee;

        SetMeltFeeDataBuilder() {
        }

        public SetMeltFeeDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public SetMeltFeeDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public SetMeltFeeDataBuilder meltFee(final Integer meltFee) {
            this.meltFee = meltFee;
            return this;
        }

        public SetMeltFeeData build() {
            return new SetMeltFeeData(tokenId, tokenIndex, meltFee);
        }

        @Override
        public String toString() {
            return "SetMeltFeeData.SetMeltFeeDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", meltFee=" + this.meltFee + ")";
        }
    }

    public static SetMeltFeeDataBuilder builder() {
        return new SetMeltFeeDataBuilder();
    }
}
