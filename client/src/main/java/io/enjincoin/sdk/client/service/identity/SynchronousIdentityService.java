package io.enjincoin.sdk.client.service.identity;

import io.enjincoin.sdk.client.service.identity.vo.LinkIdentityRequestBody;
import io.enjincoin.sdk.client.service.identity.vo.LinkIdentityResponseBody;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousIdentityService {

    Response<LinkIdentityResponseBody> linkIdentitySync(String linkingCode, LinkIdentityRequestBody request) throws IOException;

}
