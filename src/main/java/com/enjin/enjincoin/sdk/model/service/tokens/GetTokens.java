package com.enjin.enjincoin.sdk.model.service.tokens;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

public class GetTokens extends GraphQLRequest.Builder {

    public GetTokens withTokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

    public GetTokens withTokenIndex(String tokenIndex) {
        withParameter("token_index", tokenIndex);
        return this;
    }

    public GetTokens withName(String name) {
        withParameter("name", name);
        return this;
    }

    public GetTokens withCreator(String creator) {
        withParameter("creator", creator);
        return this;
    }

    public GetTokens withTotalSupply(String totalSupply) {
        withParameter("totalSupply", totalSupply);
        return this;
    }

    public GetTokens withReserve(String reserve) {
        withParameter("reserve", reserve);
        return this;
    }

    public GetTokens withSupplyModel(TokenSupplyModel supplyModel) {
        withParameter("supplyModel", supplyModel);
        return this;
    }

    public GetTokens withMeltValue(String meltValue) {
        withParameter("meltValue", meltValue);
        return this;
    }

    public GetTokens withMeltFeeRatio(String meltFeeRatio) {
        withParameter("meltFeeRatio", meltFeeRatio);
        return this;
    }

    public GetTokens withTransferable(TokenTransferable transferable) {
        withParameter("transferable", transferable);
        return this;
    }

    public GetTokens withTransferFeeSettings(TokenTransferFeeSettings transferFeeSettings) {
        withParameter("transferFeeSettings", transferFeeSettings);
        return this;
    }

    public GetTokens withNonFungible(boolean nonFungible) {
        withParameter("nonFungible", nonFungible);
        return this;
    }

    public GetTokens withFirstBlock(int firstBlock) {
        withParameter("firstBlock", firstBlock);
        return this;
    }

    public GetTokens withBlockHeight(int blockHeight) {
        withParameter("blockHeight", blockHeight);
        return this;
    }

    public GetTokens withTokenIdAsInt(boolean tokenIdAsInt) {
        withParameter("token_id_as_int", tokenIdAsInt);
        return this;
    }

    public GetTokens withTokenIndexAsInt(boolean tokenIndexAsInt) {
        withParameter("token_index_as_int", tokenIndexAsInt);
        return this;
    }

    public GetTokens withMarkedForDelete(boolean markedForDelete) {
        withParameter("markedForDelete", markedForDelete);
        return this;
    }

}
