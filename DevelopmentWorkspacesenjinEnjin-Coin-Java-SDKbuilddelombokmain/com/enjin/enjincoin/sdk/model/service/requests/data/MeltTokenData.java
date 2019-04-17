package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;

public class MeltTokenData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    @SerializedName("token_index_array")
    private List<String> tokenIndexes;
    private Integer value;
    @SerializedName("value_array")
    private List<Integer> values;


    public static class MeltTokenDataBuilder {
        private String tokenId;
        private String tokenIndex;
        private List<String> tokenIndexes;
        private Integer value;
        private List<Integer> values;

        public MeltTokenDataBuilder tokenIndexes(String... tokenIndexes) {
            this.tokenIndexes = Arrays.asList(tokenIndexes);
            return this;
        }

        public MeltTokenDataBuilder tokenIndexes(List<String> tokenIndexes) {
            this.tokenIndexes = tokenIndexes;
            return this;
        }

        public MeltTokenDataBuilder values(Integer... values) {
            this.values = Arrays.asList(values);
            return this;
        }

        public MeltTokenDataBuilder values(List<Integer> values) {
            this.values = values;
            return this;
        }

        MeltTokenDataBuilder() {
        }

        public MeltTokenDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public MeltTokenDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public MeltTokenDataBuilder value(final Integer value) {
            this.value = value;
            return this;
        }

        public MeltTokenData build() {
            return new MeltTokenData(tokenId, tokenIndex, tokenIndexes, value, values);
        }

        @Override
        public String toString() {
            return "MeltTokenData.MeltTokenDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", tokenIndexes=" + this.tokenIndexes + ", value=" + this.value + ", values=" + this.values + ")";
        }
    }

    MeltTokenData(final String tokenId, final String tokenIndex, final List<String> tokenIndexes, final Integer value, final List<Integer> values) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.tokenIndexes = tokenIndexes;
        this.value = value;
        this.values = values;
    }

    public static MeltTokenDataBuilder builder() {
        return new MeltTokenDataBuilder();
    }
}
