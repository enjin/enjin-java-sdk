package com.enjin.sdk.model.service.identities;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

/**
 * An aggregated result of all tokens.
 */
@Getter
@ToString
public class AggregatedBalance {

    /**
     * The total number of tokens.
     *
     * @return the count of all owned tokens.
     */
    @SerializedName("token_count")
    private int tokenCount;

    /**
     * The total value in enj.
     *
     * @return the value of all owned tokens.
     */
    @SerializedName("enj_value")
    private String enjValue;

}
