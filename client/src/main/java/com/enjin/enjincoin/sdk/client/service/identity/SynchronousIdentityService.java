package com.enjin.enjincoin.sdk.client.service.identity;

import com.enjin.enjincoin.sdk.client.service.identity.vo.LinkIdentityRequestBody;
import com.enjin.enjincoin.sdk.client.service.identity.vo.LinkIdentityResponseBody;
import com.enjin.enjincoin.sdk.client.service.identity.vo.LinkIdentityRequestBody;
import com.enjin.enjincoin.sdk.client.service.identity.vo.LinkIdentityResponseBody;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousIdentityService {

    Response<LinkIdentityResponseBody> linkIdentitySync(String linkingCode, LinkIdentityRequestBody request) throws IOException;

}
