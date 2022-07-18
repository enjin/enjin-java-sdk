/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.models;

import com.enjin.sdk.schemas.shared.queries.GetTransactions;
import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

/**
 * Models a filter input for transaction queries.
 *
 * @see GetTransactions
 */
@EqualsAndHashCode(callSuper = true)
public class TransactionFilter extends Filter<TransactionFilter> {

    private String id;
    @SerializedName("id_in")
    private List<String> idIn;
    private String transactionId;
    @SerializedName("transactionId_in")
    private List<String> transactionIdIn;
    private String assetId;
    @SerializedName("assetId_in")
    private List<String> assetIdIn;
    private TransactionType type;
    @SerializedName("type_in")
    private List<TransactionType> typeIn;
    private Integer value;
    @SerializedName("value_gt")
    private Integer valueGt;
    @SerializedName("value_gte")
    private Integer valueGte;
    @SerializedName("value_lt")
    private Integer valueLt;
    @SerializedName("value_lte")
    private Integer valueLte;
    private TransactionState state;
    @SerializedName("state_in")
    private List<TransactionState> stateIn;
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
     * Sets the asset ID to filter for.
     *
     * @param assetId the ID
     * @return this filter for chaining
     */
    public TransactionFilter assetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    /**
     * Sets the asset IDs to filter for.
     *
     * @param assetIds the IDs
     * @return this filter for chaining
     */
    public TransactionFilter assetIdIn(String... assetIds) {
        assetIdIn = assetIds == null
                ? null
                : Arrays.asList(assetIds);
        return this;
    }

    /**
     * Sets the transaction type to filter for.
     *
     * @param type the type
     * @return this filter for chaining
     */
    public TransactionFilter type(TransactionType type) {
        this.type = type;
        return this;
    }

    /**
     * Sets the transaction types to filter for.
     *
     * @param types the types
     * @return this filter for chaining
     */
    public TransactionFilter typeIn(TransactionType... types) {
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
    public TransactionFilter state(TransactionState state) {
        this.state = state;
        return this;
    }

    /**
     * Sets the transaction states to filter for.
     *
     * @param states the states
     * @return this filter for chaining
     */
    public TransactionFilter stateIn(TransactionState... states) {
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
