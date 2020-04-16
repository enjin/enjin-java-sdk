package com.enjin.sdk;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.services.app.AppsService;
import com.enjin.sdk.services.balance.BalancesService;
import com.enjin.sdk.services.identity.IdentitiesService;
import com.enjin.sdk.services.platform.PlatformService;
import com.enjin.sdk.services.request.RequestsService;
import com.enjin.sdk.services.token.TokensService;
import com.enjin.sdk.services.user.UsersService;
import com.enjin.sdk.services.wallet.WalletService;

import java.io.Closeable;

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

    HttpResponse<GraphQLResponse<AccessToken>> authAppSync(int id, String secret);

    void authAppAsync(int id, String secret, HttpCallback<GraphQLResponse<AccessToken>> callback);

    boolean isAuthenticated();

    boolean isClosed();

    static String version() {
        return "@version@";
    }

}
