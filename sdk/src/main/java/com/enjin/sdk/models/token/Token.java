package com.enjin.sdk.models.token;

import com.enjin.sdk.models.app.App;
import com.enjin.sdk.models.user.User;
import com.enjin.sdk.models.wallet.Wallet;
import com.enjin.sdk.services.token.TokensService;
import com.google.gson.JsonElement;
import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

/**
 * Represents a Trusted Platform Token.
 *
 * @see TokensService
 */
@ToString
@Getter
public class Token {

    /**
     * -- GETTER --
     * Returns the token's id.
     *
     * @return the token id
     */
    private String id;

    /**
     * -- GETTER --
     * Returns the token's index.
     *
     * @return the token index
     */
    private String index;

    /**
     * -- GETTER --
     * Returns the token's name.
     *
     * @return the token name
     */
    private String name;

    /**
     * -- GETTER --
     * Returns the id of the {@link App} the token belongs to.
     *
     * @return the app id
     */
    private Integer appId;

    /**
     * -- GETTER --
     * Determines if the token is a non-fungible item.
     *
     * @return true if the token is non-fungible, false otherwise
     */
    private Boolean nonFungible;

    /**
     * -- GETTER --
     * Returns the {@link Wallet} address of the {@link User} who created the token.
     *
     * @return the wallet address
     */
    private String creator;

    /**
     * -- GETTER --
     * Returns the block number of the last update.
     *
     * @return the block number
     */
    private Integer blockHeight;

    /**
     * -- GETTER --
     * Returns the first block the token appeared in.
     *
     * @return the block number
     */
    private Integer firstBlock;

    /**
     * -- GETTER --
     * Returns the url for the token's icon.
     *
     * @return the url
     */
    private String icon;

    /**
     * -- GETTER --
     * Returns the melt fee ratio for the token.
     * <p>
     *     The melt fee ration is in the range 0-10000 to allow fractional ratios (e.g. 1 = 0.01).
     * </p>
     *
     * @return the melt fee ratio
     */
    private Integer meltFeeRatio;

    /**
     * -- GETTER --
     * Returns the max melt fee ratio for the token.
     * <p>
     *     The the max melt fee ratio for this item in the range 0-10000 to allow fractional ratios (e.g. 1 = 0.01%).
     * </p>
     *
     * @return the max felt fee ratio
     */
    private Integer meltFeeMaxRatio;

    /**
     * -- GETTER --
     * Returns the melt value (and exchange rate) for the token.
     *
     * @return the melt value
     */
    private BigInteger meltValue;

    /**
     * -- GETTER --
     * Determines if the token has been marked for deletion.
     *
     * @return true if the token was marked for deletion, false otherwise
     */
    private Boolean markedForDelete;

    /**
     * -- GETTER --
     * Returns the number of tokens currently available to mint.
     *
     * @return the number of tokens
     */
    private BigInteger availableToMint;

    /**
     * -- GETTER --
     * Returns the initial reserve of the token.
     *
     * @return the reserve
     */
    private String reserve;

    /**
     * -- GETTER --
     * Returns the token's supply model.
     *
     * @return the model
     */
    private TokenSupplyModel supplyModel;

    /**
     * -- GETTER --
     * Returns the circulating supply of the token.
     *
     * @return the circulating supply
     */
    private BigInteger circulatingSupply;

    /**
     * -- GETTER --
     * Returns the total supply of the token.
     *
     * @return the total supply
     */
    private BigInteger totalSupply;

    /**
     * -- GETTER --
     * Returns the fee settings for the token.
     *
     * @return the settings
     */
    private TokenTransferFeeSettings transferFeeSettings;

    /**
     * -- GETTER --
     * Returns the transferable type of the token.
     *
     * @return the transferable
     */
    private TokenTransferable transferable;

    /**
     * -- GETTER --
     * Returns the uri for the token (if set).
     *
     * @return the uri
     */
    private String itemURI;

    /**
     * -- GETTER --
     * Returns the hosted metadata for the token.
     *
     * @return the metadata
     */
    private JsonElement metadata;

    /**
     * -- GETTER --
     * Returns the variant mode of the token.
     *
     * @return the variant mode
     */
    private TokenVariantMode variantMode;

    /**
     * -- GETTER --
     * Returns the ISO 8601 datetime when the token was created.
     *
     * @return the time the token was created
     */
    private String createdAt;

    /**
     * -- GETTER --
     * Returns the ISO 8601 datetime when this resource was last updated.
     *
     * @return the time the token was last updated
     */
    private String updatedAt;

}
