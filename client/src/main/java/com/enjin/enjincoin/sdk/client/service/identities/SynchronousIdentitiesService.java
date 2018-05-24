package com.enjin.enjincoin.sdk.client.service.identities;

import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityField;
import com.google.gson.JsonElement;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public interface SynchronousIdentitiesService {

    Response<JsonElement> getAllIdentitiesSync() throws IOException;

    Response<JsonElement> getIdentitiesSync(Integer id, String ethereumAddress) throws IOException;

    Response<JsonElement> createIdentitySync(Integer id, String ethereumAddress, List<IdentityField> fields) throws IOException;

    Response<JsonElement> updateIdentitySync(Integer id, Integer appId, Integer userId,
                                             String ethereumAddress,
                                             List<IdentityField> fields) throws IOException;
}
