package com.enjin.enjincoin.sdk.client.service.identities;

import com.enjin.enjincoin.sdk.client.service.identities.vo.*;
import com.enjin.enjincoin.sdk.client.service.identities.vo.*;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;

public interface SynchronousIdentitiesService {

    Response<Identity[]> getIdentitiesSync() throws IOException;

    Response<Identity[]> getIdentitiesSync(Map<String, Object> filter) throws IOException;

    Response<Identity> getIdentitySync(long id) throws IOException;

    Response<CreateIdentityResponseBody> createIdentitySync(int appId) throws IOException;

    Response<CreateIdentityResponseBody> createIdentitySync(CreateIdentityRequestBody request) throws IOException;

    Response<UpdateIdentityResponseBody> updateIdentitySync(long id, UpdateIdentityRequestBody request) throws IOException;

    Response<Boolean> deleteIdentitySync(long id) throws IOException;

}
