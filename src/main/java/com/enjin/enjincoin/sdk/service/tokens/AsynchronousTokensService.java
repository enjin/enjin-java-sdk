package com.enjin.enjincoin.sdk.service.tokens;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.query.GetTokens;
import com.enjin.enjincoin.sdk.model.query.ImportToken;
import com.enjin.enjincoin.sdk.model.query.UpdateToken;
import com.enjin.enjincoin.sdk.service.requests.vo.TransactionType;
import com.enjin.enjincoin.sdk.service.tokens.vo.TokenSupplyModel;
import com.enjin.enjincoin.sdk.service.tokens.vo.TokenTransferFeeSettings;
import com.enjin.enjincoin.sdk.service.tokens.vo.TokenTransferable;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.CreateTokenData;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.TokensData;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.UpdateTokenData;
import com.google.gson.JsonObject;

public interface AsynchronousTokensService {

    /**
     * @param callback
     */
    void getAllTokensAsync(Callback<GraphQLResponse<TokensData>> callback);

    /**
     * @param query
     * @param callback
     */
    void getTokensAsync(GetTokens query,
                        Callback<GraphQLResponse<TokensData>> callback);

    /**
     * @param query
     * @param callback
     */
    void importTokenAsync(ImportToken query,
                          Callback<GraphQLResponse<CreateTokenData>> callback);

    /**
     * @param query
     * @param callback
     */
    void updateTokenAsync(UpdateToken query,
                          Callback<GraphQLResponse<UpdateTokenData>> callback);

}
