package com.enjin.sdk.models.token;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.token.TokensService;

/**
 * The results of a get token request.
 *
 * @author Evan Lindsay
 * @see TokensService
 */
public class GetTokens extends PaginationRequest<GetTokens> implements TokenFragment<GetTokens> {

    public GetTokens appId(Integer appId) {
        set("appId", appId);
        return this;
    }

    /**
     * The token id.
     *
     * @param tokenId the token id.
     *
     * @return the builder.
     */
    public GetTokens tokenId(String tokenId) {
        set("id", tokenId);
        return this;
    }

    /**
     * The token name.
     *
     * @param name the token name.
     *
     * @return the builder.
     */
    public GetTokens name(String name) {
        set("name", name);
        return this;
    }

    /**
     * The token creator.
     *
     * @param creator creator ethereum address.
     *
     * @return the builder.
     */
    public GetTokens creator(String creator) {
        set("creator", creator);
        return this;
    }

    /**
     * The total supply.
     *
     * @param totalSupply the total supply.
     *
     * @return the builder.
     */
    public GetTokens totalSupply(String totalSupply) {
        set("totalSupply", totalSupply);
        return this;
    }

    /**
     * The reserve amount.
     *
     * @param reserve the reserve amount.
     *
     * @return the builder.
     */
    public GetTokens reserve(String reserve) {
        set("reserve", reserve);
        return this;
    }

    /**
     * The supply model.
     *
     * @param supplyModel the supply model.
     *
     * @return the builder.
     */
    public GetTokens supplyModel(TokenSupplyModel supplyModel) {
        set("supplyModel", supplyModel);
        return this;
    }

    /**
     * The melt value.
     *
     * @param meltValue the melt value.
     *
     * @return the builder.
     */
    public GetTokens meltValue(String meltValue) {
        set("meltValue", meltValue);
        return this;
    }

    /**
     * The melt fee ratio.
     *
     * @param meltFeeRatio the fee ratio.
     *
     * @return the builder.
     */
    public GetTokens meltFeeRatio(String meltFeeRatio) {
        set("meltFeeRatio", meltFeeRatio);
        return this;
    }

    /**
     * Whether non-fungible or not.
     *
     * @return the builder.
     */
    public GetTokens nonFungibleOnly() {
        set("nonFungible", true);
        return this;
    }

    /**
     * The first block this token existed.
     *
     * @param firstBlock the block.
     *
     * @return the builder.
     */
    public GetTokens firstBlock(int firstBlock) {
        set("firstBlock", firstBlock);
        return this;
    }

    /**
     * The block height of this token.
     *
     * @param blockHeight the block height.
     *
     * @return the builder.
     */
    public GetTokens blockHeight(int blockHeight) {
        set("blockHeight", blockHeight);
        return this;
    }

    /**
     * Whether the token is marked for deletion or not.
     *
     * @return the builder.
     */
    public GetTokens markForDelete() {
        set("markedForDelete", true);
        return this;
    }

}
