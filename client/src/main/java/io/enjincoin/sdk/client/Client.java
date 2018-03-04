package io.enjincoin.sdk.client;

import io.enjincoin.sdk.client.service.identities.IdentitiesService;

public interface Client {

    IdentitiesService getIdentitiesService();

}
