package io.enjincoin.sdk.client;

import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.identity.IdentityService;

import java.io.Closeable;

public interface Client extends Closeable {

    IdentitiesService getIdentitiesService();

    IdentityService getIdentityService();

}
