package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.util.Arrays;
import java.util.List;

@Builder
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
    }

}
