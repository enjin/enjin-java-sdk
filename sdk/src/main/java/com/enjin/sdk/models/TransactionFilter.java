package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 */
public class TransactionFilter extends Filter<TransactionFilter> {

    private String id;
    @SerializedName("id_in")
    private List<String> idIn;
    private String transactionId;
    @SerializedName("transactionId_in")
    private List<String> transactionIdIn;
    private String tokenId;
    @SerializedName("tokenId_in")
    private List<String> tokenIdIn;
    private RequestType type;
    @SerializedName("type_in")
    private List<RequestType> typeIn;
    private Integer value;
    @SerializedName("value_gt")
    private Integer valueGt;
    @SerializedName("value_gte")
    private Integer valueGte;
    @SerializedName("value_lt")
    private Integer valueLt;
    @SerializedName("value_lte")
    private Integer valueLte;
    private RequestState state;
    @SerializedName("state_in")
    private List<RequestState> stateIn;
    private String wallet;
    @SerializedName("wallet_in")
    private List<String> walletIn;

    /**
     * TODO
     * @param id
     * @return
     */
    public TransactionFilter id(String id) {
        this.id = id;
        return this;
    }

    /**
     * TODO
     * @param ids
     * @return
     */
    public TransactionFilter idIn(String... ids) {
        idIn = ids == null
                ? null
                : Arrays.asList(ids);
        return this;
    }

    /**
     * TODO
     * @param transactionId
     * @return
     */
    public TransactionFilter transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * TODO
     * @param transactionIds
     * @return
     */
    public TransactionFilter transactionIdIn(String... transactionIds) {
        transactionIdIn = transactionIds == null
                ? null
                : Arrays.asList(transactionIds);
        return this;
    }

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public TransactionFilter tokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    /**
     * TODO
     * @param tokenIds
     * @return
     */
    public TransactionFilter tokenIdIn(String... tokenIds) {
        tokenIdIn = tokenIds == null
                ? null
                : Arrays.asList(tokenIds);
        return this;
    }

    /**
     * TODO
     * @param type
     * @return
     */
    public TransactionFilter type(RequestType type) {
        this.type = type;
        return this;
    }

    /**
     * TODO
     * @param types
     * @return
     */
    public TransactionFilter typeIn(RequestType... types) {
        typeIn = types == null
                ? null
                : Arrays.asList(types);
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public TransactionFilter value(Integer value) {
        this.value = value;
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public TransactionFilter valueGreaterThan(Integer value) {
        valueGt = value;
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public TransactionFilter valueGreaterThanOrEqual(Integer value) {
        valueGte = value;
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public TransactionFilter valueLessThan(Integer value) {
        valueLt = value;
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public TransactionFilter valueLessThanOrEqual(Integer value) {
        valueLte = value;
        return this;
    }

    /**
     * TODO
     * @param state
     * @return
     */
    public TransactionFilter state(RequestState state) {
        this.state = state;
        return this;
    }

    /**
     * TODO
     * @param states
     * @return
     */
    public TransactionFilter stateIn(RequestState... states) {
        stateIn = states == null
                ? null
                : Arrays.asList(states);
        return this;
    }

    /**
     * TODO
     * @param wallet
     * @return
     */
    public TransactionFilter wallet(String wallet) {
        this.wallet = wallet;
        return this;
    }

    /**
     * TODO
     * @param wallets
     * @return
     */
    public TransactionFilter walletIn(String... wallets) {
        walletIn = wallets == null
                ? null
                : Arrays.asList(wallets);
        return this;
    }

}
