package com.enjin.enjincoin.sdk.model.service.tokens;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

/**
 * The results of a get token request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.tokens.TokensService
 */
public class GetTokens extends GraphQLRequest.Builder {

    /**
     * The token id.
     *
     * @param tokenId the token id.
     * @return the builder.
     */
    public GetTokens withTokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

    /**
     * The token index.
     *
     * @param tokenIndex the token index.
     * @return the builder.
     */
    public GetTokens withTokenIndex(String tokenIndex) {
        withParameter("token_index", tokenIndex);
        return this;
    }

    /**
     * The token name.
     *
     * @param name the token name.
     * @return the builder.
     */
    public GetTokens withName(String name) {
        withParameter("name", name);
        return this;
    }

    /**
     * The token creator.
     *
     * @param creator creator ethereum address.
     * @return the builder.
     */
    public GetTokens withCreator(String creator) {
        withParameter("creator", creator);
        return this;
    }

    /**
     * The total supply.
     *
     * @param totalSupply the total supply.
     * @return the builder.
     */
    public GetTokens withTotalSupply(String totalSupply) {
        withParameter("totalSupply", totalSupply);
        return this;
    }

    /**
     * The reserve amount.
     *
     * @param reserve the reserve amount.
     * @return the builder.
     */
    public GetTokens withReserve(String reserve) {
        withParameter("reserve", reserve);
        return this;
    }

    /**
     * The supply model.
     *
     * @param supplyModel the supply model.
     * @return the builder.
     */
    public GetTokens withSupplyModel(TokenSupplyModel supplyModel) {
        withParameter("supplyModel", supplyModel);
        return this;
    }

    /**
     * The melt value.
     *
     * @param meltValue the melt value.
     * @return the builder.
     */
    public GetTokens withMeltValue(String meltValue) {
        withParameter("meltValue", meltValue);
        return this;
    }

    /**
     * The melt fee ratio.
     *
     * @param meltFeeRatio the fee ratio.
     * @return the builder.
     */
    public GetTokens withMeltFeeRatio(String meltFeeRatio) {
        withParameter("meltFeeRatio", meltFeeRatio);
        return this;
    }

    /**
     * The transferable type.
     *
     * @param transferable the type.
     * @return the builder.
     */
    public GetTokens withTransferable(TokenTransferable transferable) {
        withParameter("transferable", transferable);
        return this;
    }

    /**
     * The transfer fee settings.
     *
     * @param transferFeeSettings the settings.
     * @return the builder.
     */
    public GetTokens withTransferFeeSettings(TokenTransferFeeSettings transferFeeSettings) {
        withParameter("transferFeeSettings", transferFeeSettings);
        return this;
    }

    /**
     * Whether non-fungible or not.
     *
     * @param nonFungible is it non-fungible?
     * @return the builder.
     */
    public GetTokens withNonFungible(boolean nonFungible) {
        withParameter("nonFungible", nonFungible);
        return this;
    }

    /**
     * The first block this token existed.
     *
     * @param firstBlock the block.
     * @return the builder.
     */
    public GetTokens withFirstBlock(int firstBlock) {
        withParameter("firstBlock", firstBlock);
        return this;
    }

    /**
     * The block height of this token.
     *
     * @param blockHeight the block height.
     * @return the builder.
     */
    public GetTokens withBlockHeight(int blockHeight) {
        withParameter("blockHeight", blockHeight);
        return this;
    }

    /**
     * Whether to return the token id as an int.
     *
     * @param tokenIdAsInt return the id as an int?
     * @return the builder.
     */
    public GetTokens withTokenIdAsInt(boolean tokenIdAsInt) {
        withParameter("token_id_as_int", tokenIdAsInt);
        return this;
    }

    /**
     * Whether to return the token index as an int.
     *
     * @param tokenIndexAsInt return the index as an int?
     * @return the builder.
     */
    public GetTokens withTokenIndexAsInt(boolean tokenIndexAsInt) {
        withParameter("token_index_as_int", tokenIndexAsInt);
        return this;
    }

    /**
     * Whether the token is marked for deletion or not.
     *
     * @param markedForDelete is it marked for deletion?
     * @return the builder.
     */
    public GetTokens withMarkedForDelete(boolean markedForDelete) {
        withParameter("markedForDelete", markedForDelete);
        return this;
    }

}
