package io.enjincoin.sdk.client.service.identities;


import java.util.Map;

import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.GetIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.LinkIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.LinkIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.UpdateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.UpdateIdentityResponseBody;
import retrofit2.Callback;

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
