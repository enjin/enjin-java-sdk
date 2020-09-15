package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Models a filter input for transaction queries.
 *
 * @see com.enjin.sdk.schemas.shared.queries.GetRequests
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
     * Sets the ID to filter for.
     *
     * @param id the ID
     * @return this filter for chaining
     */
    public TransactionFilter id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Sets the IDs to filter for.
     *
     * @param ids the IDs
     * @return this filter for chaining
     */
    public TransactionFilter idIn(String... ids) {
        idIn = ids == null
                ? null
                : Arrays.asList(ids);
        return this;
    }

    /**
     * Sets the hash ID to filter for.
     *
     * @param transactionId the hash ID
     * @return this filter for chaining
     */
    public TransactionFilter transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * Sets the hash IDs to filter for.
     *
     * @param transactionIds the hash IDs
     * @return this filter for chaining
     */
    public TransactionFilter transactionIdIn(String... transactionIds) {
        transactionIdIn = transactionIds == null
                ? null
                : Arrays.asList(transactionIds);
        return this;
    }

    /**
     * Sets the token (item) ID to filter for.
     *
     * @param tokenId the ID
     * @return this filter for chaining
     */
    public TransactionFilter tokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    /**
     * Sets the token (item) IDs to filter for.
     *
     * @param tokenIds the IDs
     * @return this filter for chaining
     */
    public TransactionFilter tokenIdIn(String... tokenIds) {
        tokenIdIn = tokenIds == null
                ? null
                : Arrays.asList(tokenIds);
        return this;
    }

    /**
     * Sets the transaction type to filter for.
     *
     * @param type the type
     * @return this filter for chaining
     */
    public TransactionFilter type(RequestType type) {
        this.type = type;
        return this;
    }

    /**
     * Sets the transaction types to filter for.
     *
     * @param types the types
     * @return this filter for chaining
     */
    public TransactionFilter typeIn(RequestType... types) {
        typeIn = types == null
                ? null
                : Arrays.asList(types);
        return this;
    }

    /**
     * Sets the filter to include transactions equal to the passed value.
     *
     * @param value the value to compare by
     * @return this filter for chaining
     */
    public TransactionFilter value(Integer value) {
        this.value = value;
        return this;
    }

    /**
     * Sets the filter to include transactions greater than the passed value.
     *
     * @param value the value to compare by
     * @return this filter for chaining
     */
    public TransactionFilter valueGreaterThan(Integer value) {
        valueGt = value;
        return this;
    }

    /**
     * Sets the filter to include transactions greater than or equal to the passed value.
     *
     * @param value the value to compare by
     * @return this filter for chaining
     */
    public TransactionFilter valueGreaterThanOrEqual(Integer value) {
        valueGte = value;
        return this;
    }

    /**
     * Sets the filter to include transactions less than the passed value.
     *
     * @param value the value to compare by
     * @return this filter for chaining
     */
    public TransactionFilter valueLessThan(Integer value) {
        valueLt = value;
        return this;
    }

    /**
     * Sets the filter to include transactions less than or equal to the passed value.
     *
     * @param value the value to compare by
     * @return this filter for chaining
     */
    public TransactionFilter valueLessThanOrEqual(Integer value) {
        valueLte = value;
        return this;
    }

    /**
     * Sets the transaction state to filter for.
     *
     * @param state the state
     * @return this filter for chaining
     */
    public TransactionFilter state(RequestState state) {
        this.state = state;
        return this;
    }

    /**
     * Sets the transaction states to filter for.
     *
     * @param states the states
     * @return this filter for chaining
     */
    public TransactionFilter stateIn(RequestState... states) {
        stateIn = states == null
                ? null
                : Arrays.asList(states);
        return this;
    }

    /**
     * Sets the wallet to filter for.
     *
     * @param wallet the wallet address
     * @return this filter for chaining
     */
    public TransactionFilter wallet(String wallet) {
        this.wallet = wallet;
        return this;
    }

    /**
     * Sets the wallets to filter for.
     *
     * @param wallets the wallet addresses
     * @return this filter for chaining
     */
    public TransactionFilter walletIn(String... wallets) {
        walletIn = wallets == null
                ? null
                : Arrays.asList(wallets);
        return this;
    }

}
