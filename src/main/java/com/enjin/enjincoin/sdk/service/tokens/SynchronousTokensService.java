package com.enjin.enjincoin.sdk.service.tokens;

import com.enjin.enjincoin.sdk.Response;
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

import java.io.IOException;

public interface SynchronousTokensService {

    /**
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<TokensData>> getAllTokensSync() throws IOException;


    /**
     * @param query
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<TokensData>> getTokensSync(GetTokens query) throws IOException;

    /**
     * @param query
     */
    Response<GraphQLResponse<CreateTokenData>> importTokenSync(ImportToken query) throws IOException;

    /**
     * @param query
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<UpdateTokenData>> updateTokenSync(UpdateToken query) throws IOException;

}
