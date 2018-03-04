package io.enjincoin.sdk.client.service.identities;

import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.GetIdentityResponseBody;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;

public interface IdentitiesService {

    void getIdentitiesAsync(Callback<GetIdentityResponseBody[]> callback);

    Response<GetIdentityResponseBody[]> getIdentitiesSync() throws IOException;

    void getIdentitiesAsync(Map<String, Object> filter, Callback<GetIdentityResponseBody[]> callback);

    Response<GetIdentityResponseBody[]> getIdentitiesSync(Map<String, Object> filter) throws IOException;

    void getIdentityAsync(int id, Callback<GetIdentityResponseBody> callback);

    Response<GetIdentityResponseBody> getIdentitySync(int id) throws IOException;

    void createIdentityAsync(Callback<CreateIdentityResponseBody> callback);

    Response<CreateIdentityResponseBody> createIdentitySync() throws IOException;

    void createIdentityAsync(CreateIdentityRequestBody request, Callback<CreateIdentityResponseBody> callback);

    Response<CreateIdentityResponseBody> createIdentitySync(CreateIdentityRequestBody request) throws IOException;

}
