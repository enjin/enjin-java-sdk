package com.enjin.sdk.model.service.tokens;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Token {

    /**
     * The token id.
     *
     * @return the token id.
     */
    @SerializedName("token_id")
    private String tokenId;

    /**
     * The app id.
     *
     * @return the app id.
     */
    @SerializedName("app_id")
    private Integer appId;

    /**
     * The token name.
     *
     * @return the name.
     */
    private String name;

    /**
     * The creator ethereum address.
     *
     * @return the creator ethereum address.
     */
    private String creator;

    /**
     * The melt value.
     *
     * @return the melt value.
     */
    private String meltValue;

    /**
     * The melt fee ratio.
     *
     * @return the fee ratio.
     */
    private Integer meltFeeRatio;

    /**
     * The melt fee max ratio.
     *
     * @return the max fee ratio.
     */
    private Integer meltFeeMaxRatio;

    /**
     * The supply model.
     *
     * @return the supply model.
     */
    private TokenSupplyModel supplyModel;

    /**
     * The total supply.
     *
     * @return the total supply.
     */
    private String totalSupply;

    /**
     * The circulating supply.
     *
     * @return the circulating supply.
     */
    private String circulatingSupply;

    /**
     * The reserve.
     *
     * @return the reserve.
     */
    private String reserve;

    /**
     * The transferable type.
     *
     * @return the transferable type.
     */
    private TokenTransferable transferable;

    /**
     * The transfer fee settings.
     *
     * @return the settings.
     */
    private TokenTransferFeeSettings transferFeeSettings;

    /**
     * Whether the token is non-fungible or not.
     *
     * @return is it non-fungible?
     */
    private Boolean nonFungible;

    /**
     * The first block this item existed.
     *
     * @return the first block.
     */
    private Integer firstBlock;

    /**
     * The block height.
     *
     * @return the block height.
     */
    private Integer blockHeight;

    /**
     * Whether this token is marked for deletion or not.
     *
     * @return is it marked for deletion?
     */
    @SerializedName("markedForDelete")
    private Boolean markedForDeletion;

    /**
     * Whether the tokens are held by the creator. Depends on the query context.
     *
     * @return is this owned by the creator?
     */
    private Boolean isCreator;

    /**
     * The balance.
     *
     * @return the balance.
     */
    private Integer balance;

    /**
     * The item index.
     *
     * @return the index.
     */
    private String index;

    /**
     * The amount available to mint.
     *
     * @return the amount available to mint.
     */
    private String availableToMint;

    /**
     * The item uri.
     *
     * @return the uri.
     */
    private String itemURI;

}
