package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Models a filter input for balance queries.
 *
 * @see com.enjin.sdk.schemas.shared.queries.GetBalances
 */
public class BalanceFilter extends Filter<BalanceFilter> {

    private String tokenId;
    @SerializedName("tokenId_in")
    private List<String> tokenIdIn;
    private String wallet;
    @SerializedName("wallet_in")
    private List<String> walletIn;
    private Integer value;
    @SerializedName("value_gt")
    private Integer valueGt;
    @SerializedName("value_gte")
    private Integer valueGte;
    @SerializedName("value_lt")
    private Integer valueLt;
    @SerializedName("value_lte")
    private Integer valueLte;

    /**
     * Sets the token (item) ID to filter for.
     *
     * @param tokenId the token ID
     * @return this filter for chaining
     */
    public BalanceFilter tokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    /**
     * Sets the token (item) IDs to filter for.
     *
     * @param tokenIds the token IDs
     * @return this filter for chaining
     */
    public BalanceFilter tokenIdIn(String... tokenIds) {
        tokenIdIn = tokenIds == null
                ? null
                : Arrays.asList(tokenIds);
        return this;
    }

    /**
     * Sets the filter to include balances equal to the passed value.
     *
     * @param value the value to compare by
     * @return this filter for chaining
     */
    public BalanceFilter value(Integer value) {
        this.value = value;
        return this;
    }

    /**
     * Sets the filter to include balances greater than the passed value.
     *
     * @param value the value to compare by
     * @return this filter for chaining
     */
    public BalanceFilter valueGreaterThan(Integer value) {
        valueGt = value;
        return this;
    }

    /**
     * Sets the filter to include balances greater than or equal to the passed value.
     *
     * @param value the value to compare by
     * @return this filter for chaining
     */
    public BalanceFilter valueGreaterThanOrEqual(Integer value) {
        valueGte = value;
        return this;
    }

    /**
     * Sets the filter to include balances less than the passed value.
     *
     * @param value the value to compare by
     * @return this filter for chaining
     */
    public BalanceFilter valueLessThan(Integer value) {
        valueLt = value;
        return this;
    }

    /**
     * Sets the filter to include balances less than or equal to the passed value.
     *
     * @param value the value to compare by
     * @return this filter for chaining
     */
    public BalanceFilter valueLessThanOrEqual(Integer value) {
        valueLte = value;
        return this;
    }

    /**
     * Sets the wallet to filter for.
     *
     * @param wallet the wallet address
     * @return this filter for chaining
     */
    public BalanceFilter wallet(String wallet) {
        this.wallet = wallet;
        return this;
    }

    /**
     * Sets the wallets to filter for.
     *
     * @param wallets the wallet addresses
     * @return this filter for chaining
     */
    public BalanceFilter walletIn(String... wallets) {
        walletIn = wallets == null
                ? null
                : Arrays.asList(wallets);
        return this;
    }

}
