package io.enjincoin.sdk.client.service.identities;

import io.enjincoin.sdk.client.vo.identity.GetIdentityResponseVO;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;

public interface IdentitiesService {

    void getIdentitiesAsync(Callback<GetIdentityResponseVO[]> callback);

    Response<GetIdentityResponseVO[]> getIdentitiesSync() throws IOException, RuntimeException;

    void getIdentitiesAsync(Map<String, Object> filter, Callback<GetIdentityResponseVO[]> callback);

    Response<GetIdentityResponseVO[]> getIdentitiesSync(Map<String, Object> filter) throws IOException, RuntimeException;

    void getIdentityAsync(int id, Callback<GetIdentityResponseVO> callback);

    Response<GetIdentityResponseVO> getIdentitySync(int id) throws IOException, RuntimeException;

}
