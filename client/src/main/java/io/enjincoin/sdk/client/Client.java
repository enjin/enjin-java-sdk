package io.enjincoin.sdk.client;

import java.io.Closeable;

import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.identity.IdentityService;
import io.enjincoin.sdk.client.service.requests.RequestsService;
import io.enjincoin.sdk.client.service.users.UsersService;

public interface Client extends Closeable {

    IdentitiesService getIdentitiesService();

    IdentityService getIdentityService();

    UsersService getUsersService();

    RequestsService getRequestsService();
}
