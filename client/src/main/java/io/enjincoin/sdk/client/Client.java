package io.enjincoin.sdk.client;

import io.enjincoin.sdk.client.service.identities.IdentitiesService;

import java.io.Closeable;

public interface Client extends Closeable {

    IdentitiesService getIdentitiesService();

}
