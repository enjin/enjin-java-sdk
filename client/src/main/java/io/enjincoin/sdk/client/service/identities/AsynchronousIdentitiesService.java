package io.enjincoin.sdk.client.service.identities;

import io.enjincoin.sdk.client.service.identities.vo.*;
import retrofit2.Callback;

import java.util.Map;

public interface AsynchronousIdentitiesService {

    void getIdentitiesAsync(Callback<GetIdentityResponseBody[]> callback);

    void getIdentitiesAsync(Map<String, Object> filter, Callback<GetIdentityResponseBody[]> callback);

    void getIdentityAsync(long id, Callback<GetIdentityResponseBody> callback);

    void createIdentityAsync(Callback<CreateIdentityResponseBody> callback);

    void createIdentityAsync(CreateIdentityRequestBody request, Callback<CreateIdentityResponseBody> callback);

    void updateIdentityAsync(long id, UpdateIdentityRequestBody request, Callback<UpdateIdentityResponseBody> callback);

    void deleteIdentityAsync(long id, Callback<Boolean> callback);

    void linkIdentityAsync(String linkingCode, LinkIdentityRequestBody request, Callback<LinkIdentityResponseBody> callback);

}
