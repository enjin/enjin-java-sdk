package com.enjin.enjincoin.sdk.client.service.tokens.impl;

import com.enjin.enjincoin.sdk.client.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.Token;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class TokensServiceImpl implements TokensService {

    private RetrofitTokensService service;

    public TokensServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(RetrofitTokensService.class);
    }

    @Override
    public void getTokensAsync(Callback<Token[]> callback) {
        Call<Token[]> call = service.getTokens();
        call.enqueue(callback);
    }

    @Override
    public void getTokenAsync(long id, Callback<Token> callback) {
        Call<Token> call = service.getToken(id);
        call.enqueue(callback);
    }

    @Override
    public void createTokenAsync(Token request, Callback<Token> callback) {
        Call<Token> call = service.createToken(request);
        call.enqueue(callback);
    }

    @Override
    public void updateTokenAsync(long id, Token request, Callback<Token> callback) {
        Call<Token> call = service.updateToken(id, request);
        call.enqueue(callback);
    }

    @Override
    public void deleteTokenAsync(long id, Callback<Boolean> callback) {
        Call<Boolean> call = service.deleteToken(id);
        call.enqueue(callback);
    }

    @Override
    public Response<Token[]> getTokensSync() throws IOException {
        Call<Token[]> call = service.getTokens();
        return call.execute();
    }

    @Override
    public Response<Token> getTokenSync(long id) throws IOException {
        Call<Token> call = service.getToken(id);
        return call.execute();
    }

    @Override
    public Response<Token> createTokenSync(Token request) throws IOException {
        Call<Token> call = service.createToken(request);
        return call.execute();
    }

    @Override
    public Response<Token> updateTokenSync(long id, Token request) throws IOException {
        Call<Token> call = service.updateToken(id, request);
        return call.execute();
    }

    @Override
    public Response<Boolean> deleteTokenSync(long id) throws IOException {
        Call<Boolean> call = service.deleteToken(id);
        return call.execute();
    }

}
