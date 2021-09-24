/* Copyright 2021 Enjin Pte Ltd.
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

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

/**
 * Models a filter input for balance queries.
 *
 * @see com.enjin.sdk.schemas.shared.queries.GetBalances
 */
@EqualsAndHashCode(callSuper = true)
public class BalanceFilter extends Filter<BalanceFilter> {

    private String projectUuid;
    @SerializedName("projectUuid_in")
    private List<String> projectUuidIn;
    private String assetId;
    @SerializedName("assetId_in")
    private List<String> assetIdIn;
    private String wallet;
    @SerializedName("wallet_in")
    private List<String> walletIn;
    private Integer value;
    @SerializedName("value_is")
    private Operator valueIs;

    /**
     * Sets the project UUID to filter for.
     *
     * @param projectUuid the project UUID
     * @return this filter for chaining
     */
    public BalanceFilter projectUuid(String projectUuid) {
        this.projectUuid = projectUuid;
        return this;
    }

    /**
     * Sets the project UUIDs to filter for.
     *
     * @param projectUuids the project UUIDs
     * @return this filter for chaining
     */
    public BalanceFilter projectUuidIn(String... projectUuids) {
        projectUuidIn = projectUuids == null
                ? null
                : Arrays.asList(projectUuids);
        return this;
    }

    /**
     * Sets the asset ID to filter for.
     *
     * @param assetId the asset ID
     * @return this filter for chaining
     */
    public BalanceFilter assetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    /**
     * Sets the asset IDs to filter for.
     *
     * @param assetIds the asset IDs
     * @return this filter for chaining
     */
    public BalanceFilter assetIdIn(String... assetIds) {
        assetIdIn = assetIds == null
                ? null
                : Arrays.asList(assetIds);
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
     * Sets the filter operator type for values.
     *
     * @param valueIs the operator for comparison
     * @return this filter for chaining
     */
    public BalanceFilter valueIs(Operator valueIs) {
        this.valueIs = valueIs;
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
