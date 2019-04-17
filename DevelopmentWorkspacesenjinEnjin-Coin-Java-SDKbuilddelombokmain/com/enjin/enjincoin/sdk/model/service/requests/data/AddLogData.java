package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class AddLogData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    private String data;

    AddLogData(final String tokenId, final String tokenIndex, final String data) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.data = data;
    }


    public static class AddLogDataBuilder {
        private String tokenId;
        private String tokenIndex;
        private String data;

        AddLogDataBuilder() {
        }

        public AddLogDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public AddLogDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public AddLogDataBuilder data(final String data) {
            this.data = data;
            return this;
        }

        public AddLogData build() {
            return new AddLogData(tokenId, tokenIndex, data);
        }

        @Override
        public String toString() {
            return "AddLogData.AddLogDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", data=" + this.data + ")";
        }
    }

    public static AddLogDataBuilder builder() {
        return new AddLogDataBuilder();
    }
}
