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

import com.enjin.sdk.schemas.shared.queries.GetAssets;
import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

/**
 * Models a filter input for asset queries.
 *
 * @see GetAssets
 */
@EqualsAndHashCode(callSuper = true)
public class AssetFilter extends Filter<AssetFilter> {

    private String id;
    @SerializedName("id_in")
    private List<String> idIn;
    private String name;
    @SerializedName("name_contains")
    private String nameContains;
    @SerializedName("name_in")
    private List<String> nameIn;
    @SerializedName("name_starts_with")
    private String nameStartsWith;
    @SerializedName("name_ends_with")
    private String nameEndsWith;
    private String wallet;
    @SerializedName("wallet_in")
    private List<String> walletIn;

    /**
     * Sets the asset ID to filter for.
     *
     * @param id the ID
     * @return this filter for chaining
     */
    public AssetFilter id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Sets the name to filter for.
     *
     * @param name the name
     * @return this filter for chaining
     */
    public AssetFilter name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the filter to include assets with names which include the passed string.
     *
     * @param text the text
     * @return this filter for chaining
     */
    public AssetFilter nameContains(String text) {
        nameContains = text;
        return this;
    }

    /**
     * Sets the asset IDs to filter for.
     *
     * @param ids the IDs
     * @return this filter for chaining
     */
    public AssetFilter idIn(String... ids) {
        idIn = ids == null
                ? null
                : Arrays.asList(ids);
        return this;
    }

    /**
     * Sets the names to filter for.
     *
     * @param names the names
     * @return this filter for chaining
     */
    public AssetFilter nameIn(String... names) {
        nameIn = names == null
                ? null
                : Arrays.asList(names);
        return this;
    }

    /**
     * Sets the filter to include assets with names which start with the passed string.
     *
     * @param prefix the prefix
     * @return this filter for chaining
     */
    public AssetFilter nameStartsWith(String prefix) {
        nameStartsWith = prefix;
        return this;
    }

    /**
     * Sets the filter to include assets with names which end with the passed string.
     *
     * @param suffix the suffix
     * @return this filter for chaining
     */
    public AssetFilter nameEndsWith(String suffix) {
        nameEndsWith = suffix;
        return this;
    }

    /**
     * Sets the wallet to filter for.
     *
     * @param wallet the wallet address
     * @return this filter for chaining
     */
    public AssetFilter wallet(String wallet) {
        this.wallet = wallet;
        return this;
    }

    /**
     * Sets the wallets to filter for.
     *
     * @param wallets the wallet addresses
     * @return this filter for chaining
     */
    public AssetFilter walletIn(String... wallets) {
        walletIn = wallets == null
                ? null
                : Arrays.asList(wallets);
        return this;
    }

}
