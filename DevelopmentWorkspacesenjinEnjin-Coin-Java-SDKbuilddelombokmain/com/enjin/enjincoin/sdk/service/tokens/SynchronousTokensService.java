package com.enjin.enjincoin.sdk.service.tokens;

import com.enjin.enjincoin.sdk.http.Result;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.tokens.CreateTokenResult;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokens;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokensResult;
import com.enjin.enjincoin.sdk.model.service.tokens.ImportToken;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateToken;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateTokenResult;

import java.io.IOException;

public interface SynchronousTokensService {

    /**
     * @return
     *
     * @throws IOException
     */
    Result<GraphQLResponse<GetTokensResult>> getAllTokensSync() throws IOException;


    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Result<GraphQLResponse<GetTokensResult>> getTokensSync(GetTokens query) throws IOException;

    /**
     * @param query
     */
    Result<GraphQLResponse<CreateTokenResult>> importTokenSync(ImportToken query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Result<GraphQLResponse<UpdateTokenResult>> updateTokenSync(UpdateToken query) throws IOException;

}
