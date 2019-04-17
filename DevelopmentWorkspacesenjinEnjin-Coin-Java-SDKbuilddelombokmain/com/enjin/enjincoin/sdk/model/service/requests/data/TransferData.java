package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class TransferData {
    private String from;
    @SerializedName("from_id")
    private Integer fromId;
    private String to;
    @SerializedName("to_id")
    private Integer toId;
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    private String value;

    TransferData(final String from, final Integer fromId, final String to, final Integer toId, final String tokenId, final String tokenIndex, final String value) {
        this.from = from;
        this.fromId = fromId;
        this.to = to;
        this.toId = toId;
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.value = value;
    }


    public static class TransferDataBuilder {
        private String from;
        private Integer fromId;
        private String to;
        private Integer toId;
        private String tokenId;
        private String tokenIndex;
        private String value;

        TransferDataBuilder() {
        }

        public TransferDataBuilder from(final String from) {
            this.from = from;
            return this;
        }

        public TransferDataBuilder fromId(final Integer fromId) {
            this.fromId = fromId;
            return this;
        }

        public TransferDataBuilder to(final String to) {
            this.to = to;
            return this;
        }

        public TransferDataBuilder toId(final Integer toId) {
            this.toId = toId;
            return this;
        }

        public TransferDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public TransferDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public TransferDataBuilder value(final String value) {
            this.value = value;
            return this;
        }

        public TransferData build() {
            return new TransferData(from, fromId, to, toId, tokenId, tokenIndex, value);
        }

        @Override
        public String toString() {
            return "TransferData.TransferDataBuilder(from=" + this.from + ", fromId=" + this.fromId + ", to=" + this.to + ", toId=" + this.toId + ", tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", value=" + this.value + ")";
        }
    }

    public static TransferDataBuilder builder() {
        return new TransferDataBuilder();
    }
}
