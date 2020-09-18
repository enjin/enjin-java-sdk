package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Models a filter input for token queries.
 *
 * @see com.enjin.sdk.schemas.shared.queries.GetTokens
 */
public class TokenFilter extends Filter<TokenFilter> {

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
     * Sets the token (item) ID to filter for.
     *
     * @param id the ID
     * @return this filter for chaining
     */
    public TokenFilter id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Sets the name to filter for.
     *
     * @param name the name
     * @return this filter for chaining
     */
    public TokenFilter name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the filter to include items with names which include the passed string.
     *
     * @param text the text
     * @return this filter for chaining
     */
    public TokenFilter nameContains(String text) {
        nameContains = text;
        return this;
    }

    /**
     * Sets the token (item) IDs to filter for.
     *
     * @param ids the IDs
     * @return this filter for chaining
     */
    // TODO: Change method name to 'idIn'.
    public TokenFilter idId(String... ids) {
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
    public TokenFilter nameIn(String... names) {
        nameIn = names == null
                ? null
                : Arrays.asList(names);
        return this;
    }

    /**
     * Sets the filter to include items with names which start with the passed string.
     *
     * @param prefix the prefix
     * @return this filter for chaining
     */
    public TokenFilter nameStartsWith(String prefix) {
        nameStartsWith = prefix;
        return this;
    }

    /**
     * Sets the filter to include items with names which end with the passed string.
     *
     * @param suffix the suffix
     * @return this filter for chaining
     */
    public TokenFilter nameEndsWith(String suffix) {
        nameEndsWith = suffix;
        return this;
    }

    /**
     * Sets the wallet to filter for.
     *
     * @param wallet the wallet address
     * @return this filter for chaining
     */
    public TokenFilter wallet(String wallet) {
        this.wallet = wallet;
        return this;
    }

    /**
     * Sets the wallets to filter for.
     *
     * @param wallets the wallet addresses
     * @return this filter for chaining
     */
    public TokenFilter walletIn(String... wallets) {
        walletIn = wallets == null
                ? null
                : Arrays.asList(wallets);
        return this;
    }

}
