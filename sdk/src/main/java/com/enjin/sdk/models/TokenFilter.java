package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
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
     * TODO
     * @param id
     * @return
     */
    public TokenFilter id(String id) {
        this.id = id;
        return this;
    }

    /**
     * TODO
     * @param name
     * @return
     */
    public TokenFilter name(String name) {
        this.name = name;
        return this;
    }

    /**
     * TODO
     * @param text
     * @return
     */
    public TokenFilter nameContains(String text) {
        nameContains = text;
        return this;
    }

    /**
     * TODO
     * @param ids
     * @return
     */
    public TokenFilter idId(String... ids) {
        idIn = ids == null
                ? null
                : Arrays.asList(ids);
        return this;
    }

    /**
     * TODO
     * @param names
     * @return
     */
    public TokenFilter nameIn(String... names) {
        nameIn = names == null
                ? null
                : Arrays.asList(names);
        return this;
    }

    /**
     * TODO
     * @param prefix
     * @return
     */
    public TokenFilter nameStartsWith(String prefix) {
        nameStartsWith = prefix;
        return this;
    }

    /**
     * TODO
     * @param suffix
     * @return
     */
    public TokenFilter nameEndsWith(String suffix) {
        nameEndsWith = suffix;
        return this;
    }

    /**
     * TODO
     * @param wallet
     * @return
     */
    public TokenFilter wallet(String wallet) {
        this.wallet = wallet;
        return this;
    }

    /**
     * TODO
     * @param addresses
     * @return
     */
    public TokenFilter walletIn(String... addresses) {
        walletIn = addresses == null
                ? null
                : Arrays.asList(addresses);
        return this;
    }

}
