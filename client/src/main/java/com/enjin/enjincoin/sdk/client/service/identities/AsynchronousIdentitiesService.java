package com.enjin.enjincoin.sdk.client.service.identities;

import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityField;
import com.google.gson.JsonElement;
import retrofit2.Callback;

import java.util.List;

public interface AsynchronousIdentitiesService {

    void getAllIdentitiesAsync(Callback<JsonElement> callback);

    void getIdentitiesAsync(Integer id, String ethereumAddress, Callback<JsonElement> callback);

    void createIdentityAsync(Integer id, String ethereumAddress, List<IdentityField> fields, Callback<JsonElement> callback);

    void updateIdentityAsync(Integer id, Integer appId, Integer userId,
                             String ethereumAddress,
                             List<IdentityField> fields, Callback<JsonElement> callback);
}
