package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class UpdateItemNameData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    private String name;

    UpdateItemNameData(final String tokenId, final String tokenIndex, final String name) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.name = name;
    }


    public static class UpdateItemNameDataBuilder {
        private String tokenId;
        private String tokenIndex;
        private String name;

        UpdateItemNameDataBuilder() {
        }

        public UpdateItemNameDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public UpdateItemNameDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public UpdateItemNameDataBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public UpdateItemNameData build() {
            return new UpdateItemNameData(tokenId, tokenIndex, name);
        }

        @Override
        public String toString() {
            return "UpdateItemNameData.UpdateItemNameDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", name=" + this.name + ")";
        }
    }

    public static UpdateItemNameDataBuilder builder() {
        return new UpdateItemNameDataBuilder();
    }
}
