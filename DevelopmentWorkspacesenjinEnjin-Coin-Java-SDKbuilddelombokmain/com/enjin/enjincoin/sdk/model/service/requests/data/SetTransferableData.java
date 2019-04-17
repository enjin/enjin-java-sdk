package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.enjin.enjincoin.sdk.model.service.tokens.TokenTransferable;
import com.google.gson.annotations.SerializedName;

public class SetTransferableData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    private TokenTransferable transferable;

    SetTransferableData(final String tokenId, final String tokenIndex, final TokenTransferable transferable) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.transferable = transferable;
    }


    public static class SetTransferableDataBuilder {
        private String tokenId;
        private String tokenIndex;
        private TokenTransferable transferable;

        SetTransferableDataBuilder() {
        }

        public SetTransferableDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public SetTransferableDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public SetTransferableDataBuilder transferable(final TokenTransferable transferable) {
            this.transferable = transferable;
            return this;
        }

        public SetTransferableData build() {
            return new SetTransferableData(tokenId, tokenIndex, transferable);
        }

        @Override
        public String toString() {
            return "SetTransferableData.SetTransferableDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", transferable=" + this.transferable + ")";
        }
    }

    public static SetTransferableDataBuilder builder() {
        return new SetTransferableDataBuilder();
    }
}
