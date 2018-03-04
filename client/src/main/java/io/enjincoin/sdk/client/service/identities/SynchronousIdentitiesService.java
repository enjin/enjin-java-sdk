package io.enjincoin.sdk.client.service.identities;

import io.enjincoin.sdk.client.service.identities.vo.*;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;

public interface SynchronousIdentitiesService {

    Response<GetIdentityResponseBody[]> getIdentitiesSync() throws IOException;

    Response<GetIdentityResponseBody[]> getIdentitiesSync(Map<String, Object> filter) throws IOException;

    Response<GetIdentityResponseBody> getIdentitySync(long id) throws IOException;

    Response<CreateIdentityResponseBody> createIdentitySync() throws IOException;

    Response<CreateIdentityResponseBody> createIdentitySync(CreateIdentityRequestBody request) throws IOException;

    Response<UpdateIdentityResponseBody> updateIdentitySync(long id, UpdateIdentityRequestBody request) throws IOException;

    Response<Boolean> deleteIdentitySync(long id) throws IOException;

    Response<LinkIdentityResponseBody> linkIdentitySync(String linkingCode, LinkIdentityRequestBody request) throws IOException;

}
