package com.enjin.enjincoin.sdk.client.service.identities;

import com.enjin.enjincoin.sdk.client.service.identities.vo.*;
import com.enjin.enjincoin.sdk.client.service.identities.vo.*;
import retrofit2.Callback;

import java.util.Map;

public interface AsynchronousIdentitiesService {

    void getIdentitiesAsync(Callback<Identity[]> callback);

    void getIdentitiesAsync(Map<String, Object> filter, Callback<Identity[]> callback);

    void getIdentityAsync(long id, Callback<Identity> callback);

    void createIdentityAsync(int appId, Callback<CreateIdentityResponseBody> callback);

    void createIdentityAsync(CreateIdentityRequestBody request, Callback<CreateIdentityResponseBody> callback);

    void updateIdentityAsync(long id, UpdateIdentityRequestBody request, Callback<UpdateIdentityResponseBody> callback);

    void deleteIdentityAsync(long id, Callback<Boolean> callback);

}
