package com.enjin.enjincoin.sdk.model.service.identities;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

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
    private BigInteger tokenCount;

    /**
     * The total value in enj.
     *
     * @return the value of all owned tokens.
     */
    @SerializedName("enj_value")
    private BigInteger enjValue;

}
