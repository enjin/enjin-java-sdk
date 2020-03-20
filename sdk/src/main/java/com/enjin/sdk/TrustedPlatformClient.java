package com.enjin.sdk;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.auth.AuthTokens;
import com.enjin.sdk.service.apps.AppsService;
import com.enjin.sdk.service.balances.BalancesService;
import com.enjin.sdk.service.identities.IdentitiesService;
import com.enjin.sdk.service.platform.PlatformService;
import com.enjin.sdk.service.requests.RequestsService;
import com.enjin.sdk.service.tokens.TokensService;
import com.enjin.sdk.service.users.UsersService;
import com.enjin.sdk.service.wallets.WalletService;

import java.io.Closeable;
import java.io.IOException;

public interface TrustedPlatformClient extends Closeable {

    AppsService getAppService();

    BalancesService getBalanceService();

    IdentitiesService getIdentityService();

    PlatformService getPlatformService();

    RequestsService getRequestService();

    TokensService getTokenService();

    UsersService getUserService();

    WalletService getWalletService();

    void setAppId(Integer id);

    Integer getAppId();

    HttpResponse<GraphQLResponse<AuthTokens>> authAppSync(int id, String secret);

    void authAppAsync(int id, String secret, HttpCallback<GraphQLResponse<AuthTokens>> callback);

    boolean isAuthenticated();

    boolean isClosed();

}
