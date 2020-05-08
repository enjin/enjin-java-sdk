package com.enjin.sdk.models.token;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.token.TokensService;

/**
 * An object class for getting tokens from the Trusted Platform.
 *
 * @author Evan Lindsay
 * @see TokensService
 */
public class GetTokens extends PaginationRequest<GetTokens> implements TokenFragment<GetTokens> {

    /**
     * The application's id.
     *
     * @param appId the app id.
     *
     * @return this request.
     */
    public GetTokens appId(Integer appId) {
        set("appId", appId);
        return this;
    }

    /**
     * The token id.
     *
     * @param tokenId the token id.
     *
     * @return this request.
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
     * @return this request.
     */
    public GetTokens name(String name) {
        set("name", name);
        return this;
    }

    /**
     * The token creator.
     *
     * @param creator the creator's Ethereum address.
     *
     * @return this request.
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
     * @return this request.
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
     * @return this request.
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
     * @return this request.
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
     * @return this request.
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
     * @return this request.
     */
    public GetTokens meltFeeRatio(String meltFeeRatio) {
        set("meltFeeRatio", meltFeeRatio);
        return this;
    }

    /**
     * Whether non-fungible or not.
     *
     * @return this request.
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
     * @return this request.
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
     * @return this request.
     */
    public GetTokens blockHeight(int blockHeight) {
        set("blockHeight", blockHeight);
        return this;
    }

    /**
     * Whether the token is marked for deletion or not.
     *
     * @return this request.
     */
    public GetTokens markForDelete() {
        set("markedForDelete", true);
        return this;
    }

}
