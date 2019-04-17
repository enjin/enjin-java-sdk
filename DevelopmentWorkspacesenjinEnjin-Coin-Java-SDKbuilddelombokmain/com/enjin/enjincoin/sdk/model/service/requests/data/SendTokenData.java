package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class SendTokenData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    @SerializedName("recipient_address")
    private String recipientAddress;
    @SerializedName("recipient_identity_id")
    private Integer recipientIdentityId;
    private Integer value;

    SendTokenData(final String tokenId, final String tokenIndex, final String recipientAddress, final Integer recipientIdentityId, final Integer value) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.recipientAddress = recipientAddress;
        this.recipientIdentityId = recipientIdentityId;
        this.value = value;
    }


    public static class SendTokenDataBuilder {
        private String tokenId;
        private String tokenIndex;
        private String recipientAddress;
        private Integer recipientIdentityId;
        private Integer value;

        SendTokenDataBuilder() {
        }

        public SendTokenDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public SendTokenDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public SendTokenDataBuilder recipientAddress(final String recipientAddress) {
            this.recipientAddress = recipientAddress;
            return this;
        }

        public SendTokenDataBuilder recipientIdentityId(final Integer recipientIdentityId) {
            this.recipientIdentityId = recipientIdentityId;
            return this;
        }

        public SendTokenDataBuilder value(final Integer value) {
            this.value = value;
            return this;
        }

        public SendTokenData build() {
            return new SendTokenData(tokenId, tokenIndex, recipientAddress, recipientIdentityId, value);
        }

        @Override
        public String toString() {
            return "SendTokenData.SendTokenDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", recipientAddress=" + this.recipientAddress + ", recipientIdentityId=" + this.recipientIdentityId + ", value=" + this.value + ")";
        }
    }

    public static SendTokenDataBuilder builder() {
        return new SendTokenDataBuilder();
    }
}
