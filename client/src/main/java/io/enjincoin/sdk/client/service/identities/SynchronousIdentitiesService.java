package io.enjincoin.sdk.client.service.identities;

import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.GetIdentityResponseBody;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;

public interface SynchronousIdentitiesService {

    Response<GetIdentityResponseBody[]> getIdentitiesSync() throws IOException;

    Response<GetIdentityResponseBody[]> getIdentitiesSync(Map<String, Object> filter) throws IOException;

    Response<GetIdentityResponseBody> getIdentitySync(int id) throws IOException;

    Response<CreateIdentityResponseBody> createIdentitySync() throws IOException;

    Response<CreateIdentityResponseBody> createIdentitySync(CreateIdentityRequestBody request) throws IOException;

}
