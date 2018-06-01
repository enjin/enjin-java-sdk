package com.enjin.enjincoin.sdk.client;

import com.enjin.enjincoin.sdk.client.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.client.service.notifications.NotificationsService;
import com.enjin.enjincoin.sdk.client.service.platform.PlatformService;
import com.enjin.enjincoin.sdk.client.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.client.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.client.service.users.UsersService;

import java.io.Closeable;

public interface Client extends Closeable {

    int getAppId();

    IdentitiesService getIdentitiesService();

    UsersService getUsersService();

    RequestsService getRequestsService();

    TokensService getTokensService();

    PlatformService getPlatformService();

    NotificationsService getNotificationsService();
}
