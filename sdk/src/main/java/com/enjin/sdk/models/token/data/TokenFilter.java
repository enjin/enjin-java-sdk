package com.enjin.sdk.models.token.data;

import com.enjin.sdk.services.token.TokensService;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.util.Collection;

/**
 * Filter input for token queries.
 *
 * @see TokensService
 */
@Builder
public class TokenFilter {

    /**
     * The token id to filter for.
     */
    private String id;

    /**
     * The token ids to filter for.
     */
    @SerializedName("id_in")
    private Collection<String> idIn;

    /**
     * The token name to filter for.
     */
    private String name;

    /**
     * The token names to filter for.
     */
    @SerializedName("name_in")
    private Collection<String> nameIn;

    /**
     * The prefix to filter for.
     */
    @SerializedName("name_starts_with")
    private String nameStartsWith;

    /**
     * The suffix to filter for.
     */
    @SerializedName("name_ends_with")
    private String nameEndsWith;

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
     * The wallet address to filter for.
     */
    private String wallet;

    /**
     * The wallet addresses to filter for.
     */
    @SerializedName("wallet_in")
    private Collection<String> walletIn;

    /**
     * The collection of filters to intersect with.
     */
    private Collection<TokenFilter> and;

    /**
     * The collection of filters to union with.
     */
    private Collection<TokenFilter> or;

}
