package io.enjincoin.sdk.client.service.identities;

import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.GetIdentityResponseBody;
import retrofit2.Callback;

import java.util.Map;

public interface AsynchronousIdentitiesService {

    void getIdentitiesAsync(Callback<GetIdentityResponseBody[]> callback);

    void getIdentitiesAsync(Map<String, Object> filter, Callback<GetIdentityResponseBody[]> callback);

    void getIdentityAsync(int id, Callback<GetIdentityResponseBody> callback);

    void createIdentityAsync(Callback<CreateIdentityResponseBody> callback);

    void createIdentityAsync(CreateIdentityRequestBody request, Callback<CreateIdentityResponseBody> callback);

}
