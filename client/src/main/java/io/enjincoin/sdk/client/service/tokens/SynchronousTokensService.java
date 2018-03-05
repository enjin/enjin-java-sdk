package io.enjincoin.sdk.client.service.tokens;

import io.enjincoin.sdk.client.service.tokens.vo.Token;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousTokensService {

    Response<Token[]> getTokensSync() throws IOException;

    Response<Token> getTokenSync(long id) throws IOException;

    Response<Token> createTokenSync(Token request) throws IOException;

    Response<Token> updateTokenSync(long id, Token request) throws IOException;

    Response<Boolean> deleteTokenSync(long id) throws IOException;

}
