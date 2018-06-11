package com.enjin.enjincoin.sdk.client.service.identities;

import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityField;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public interface SynchronousIdentitiesService {

    Response<GraphQLResponse> getAllIdentitiesSync() throws IOException;

    Response<GraphQLResponse> getIdentitiesSync(Integer id, String ethereumAddress) throws IOException;

    Response<GraphQLResponse> createIdentitySync(Integer id, String ethereumAddress, List<IdentityField> fields) throws IOException;

    Response<GraphQLResponse> updateIdentitySync(Integer id, Integer appId, Integer userId,
                                             String ethereumAddress,
                                             List<IdentityField> fields) throws IOException;
}
