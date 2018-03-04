package io.enjincoin.sdk.client.service.identity;

import io.enjincoin.sdk.client.service.identity.vo.LinkIdentityRequestBody;
import io.enjincoin.sdk.client.service.identity.vo.LinkIdentityResponseBody;
import retrofit2.Callback;

public interface AsynchronousIdentityService {

    void linkIdentityAsync(String linkingCode, LinkIdentityRequestBody request, Callback<LinkIdentityResponseBody> callback);

}
