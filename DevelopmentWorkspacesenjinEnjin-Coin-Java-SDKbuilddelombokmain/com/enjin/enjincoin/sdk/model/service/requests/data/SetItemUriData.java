package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class SetItemUriData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    @SerializedName("item_uri")
    private String itemUri;

    SetItemUriData(final String tokenId, final String tokenIndex, final String itemUri) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.itemUri = itemUri;
    }


    public static class SetItemUriDataBuilder {
        private String tokenId;
        private String tokenIndex;
        private String itemUri;

        SetItemUriDataBuilder() {
        }

        public SetItemUriDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public SetItemUriDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public SetItemUriDataBuilder itemUri(final String itemUri) {
            this.itemUri = itemUri;
            return this;
        }

        public SetItemUriData build() {
            return new SetItemUriData(tokenId, tokenIndex, itemUri);
        }

        @Override
        public String toString() {
            return "SetItemUriData.SetItemUriDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", itemUri=" + this.itemUri + ")";
        }
    }

    public static SetItemUriDataBuilder builder() {
        return new SetItemUriDataBuilder();
    }
}
