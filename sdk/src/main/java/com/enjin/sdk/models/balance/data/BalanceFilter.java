package com.enjin.sdk.models.balance.data;

import com.enjin.sdk.services.balance.BalancesService;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.util.Collection;

/**
 * Filter input for balance queries.
 *
 * @see BalancesService
 */
@Builder
public class BalanceFilter {

    /**
     * The application id to filter for.
     */
    private Integer appId;

    /**
     * The application ids to filter for.
     */
    @SerializedName("appId_in")
    private Collection<Integer> appIdIn;

    /**
     * The token id to filter for.
     */
    private String tokenId;

    /**
     * The token ids to filter for.
     */
    @SerializedName("tokenId_in")
    private Collection<String> tokenIdIn;

    /**
     * The wallet address to filter for.
     */
    private String wallet;

    /**
     * The wallet addresses to filter for.
     */
    @SerializedName("wallet_in")
    private Collection<String> walletIn;

    /**
     * Filters for values equal to this value.
     */
    private Integer value;

    /**
     * Filters for values greater than this value.
     */
    @SerializedName("value_gt")
    private Integer valueGt;

    /**
     * Filters for values greater than or equal to this value.
     */
    @SerializedName("value_gte")
    private Integer valueGte;

    /**
     * Filters for values less than this value.
     */
    @SerializedName("value_lt")
    private Integer valueLt;

    /**
     * Filters for values less than or equal to this value.
     */
    @SerializedName("value_lte")
    private Integer valueLte;

    /**
     * The collection of filters to intersect with.
     */
    private Collection<BalanceFilter> and;

    /**
     * The collection of filters to union with.
     */
    private Collection<BalanceFilter> or;

}
