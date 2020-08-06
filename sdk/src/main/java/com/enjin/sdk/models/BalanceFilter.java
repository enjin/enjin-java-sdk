package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
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
     * TODO
     * @param tokenId
     * @return
     */
    public BalanceFilter tokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    /**
     * TODO
     * @param tokenIds
     * @return
     */
    public BalanceFilter tokenIdIn(String... tokenIds) {
        tokenIdIn = Arrays.asList(tokenIds);
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public BalanceFilter value(int value) {
        this.value = value;
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public BalanceFilter valueGt(int value) {
        valueGt = value;
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public BalanceFilter valueGte(int value) {
        valueGte = value;
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public BalanceFilter valueLt(int value) {
        valueLt = value;
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public BalanceFilter valueLte(int value) {
        valueLte = value;
        return this;
    }

    /**
     * TODO
     * @param wallet
     * @return
     */
    public BalanceFilter wallet(String wallet) {
        this.wallet = wallet;
        return this;
    }

    /**
     * TODO
     * @param wallets
     * @return
     */
    public BalanceFilter walletIn(String... wallets) {
        walletIn = Arrays.asList(wallets);
        return this;
    }

}
