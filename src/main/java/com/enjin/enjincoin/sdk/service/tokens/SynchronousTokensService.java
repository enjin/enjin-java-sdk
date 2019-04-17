package com.enjin.enjincoin.sdk.service.tokens;

import com.enjin.enjincoin.sdk.Response;
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
    Response<GraphQLResponse<GetTokensResult>> getAllTokensSync() throws IOException;


    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<GetTokensResult>> getTokensSync(GetTokens query) throws IOException;

    /**
     * @param query
     */
    Response<GraphQLResponse<CreateTokenResult>> importTokenSync(ImportToken query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<UpdateTokenResult>> updateTokenSync(UpdateToken query) throws IOException;

}
