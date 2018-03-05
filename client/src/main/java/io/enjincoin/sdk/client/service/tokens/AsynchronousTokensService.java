package io.enjincoin.sdk.client.service.tokens;

import io.enjincoin.sdk.client.service.tokens.vo.Token;
import retrofit2.Callback;

public interface AsynchronousTokensService {

    void getTokensAsync(Callback<Token[]> callback);

    void getTokenAsync(long id, Callback<Token> callback);

    void createTokenAsync(Token request, Callback<Token> callback);

    void updateTokenAsync(long id, Token request, Callback<Token> callback);

    void deleteTokenAsync(long id, Callback<Boolean> callback);
    
}
