package com.enjin.enjincoin.sdk.client;

import com.enjin.enjincoin.sdk.client.service.auth.vo.AuthData;
import com.enjin.enjincoin.sdk.client.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.client.service.notifications.NotificationsService;
import com.enjin.enjincoin.sdk.client.service.platform.PlatformService;
import com.enjin.enjincoin.sdk.client.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.client.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.client.service.users.UsersService;

import java.io.Closeable;
import java.io.IOException;

public interface Client extends Closeable {

    Response<AuthData> auth(String clientSecret) throws IOException;

    String getAppId();

    IdentitiesService getIdentitiesService();

    UsersService getUsersService();

    RequestsService getRequestsService();

    TokensService getTokensService();

    PlatformService getPlatformService();

    NotificationsService getNotificationsService();
}
