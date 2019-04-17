package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class TokenIndexPairData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;

    TokenIndexPairData(final String tokenId, final String tokenIndex) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
    }


    public static class TokenIndexPairDataBuilder {
        private String tokenId;
        private String tokenIndex;

        TokenIndexPairDataBuilder() {
        }

        public TokenIndexPairDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public TokenIndexPairDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public TokenIndexPairData build() {
            return new TokenIndexPairData(tokenId, tokenIndex);
        }

        @Override
        public String toString() {
            return "TokenIndexPairData.TokenIndexPairDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ")";
        }
    }

    public static TokenIndexPairDataBuilder builder() {
        return new TokenIndexPairDataBuilder();
    }
}
