package com.enjin.enjincoin.sdk;

import com.enjin.enjincoin.sdk.model.service.auth.AuthResult;
import com.enjin.enjincoin.sdk.service.ethereum.EthereumService;
import com.enjin.enjincoin.sdk.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.service.notifications.NotificationsService;
import com.enjin.enjincoin.sdk.service.platform.PlatformService;
import com.enjin.enjincoin.sdk.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.service.users.UsersService;

import java.io.Closeable;
import java.io.IOException;

public interface Client extends Closeable {

    Response<AuthResult> auth(String clientSecret) throws IOException;

    String getAppId();

    EthereumService getEthereumService();

    IdentitiesService getIdentitiesService();

    UsersService getUsersService();

    RequestsService getRequestsService();

    TokensService getTokensService();

    PlatformService getPlatformService();

    NotificationsService getNotificationsService();
}
