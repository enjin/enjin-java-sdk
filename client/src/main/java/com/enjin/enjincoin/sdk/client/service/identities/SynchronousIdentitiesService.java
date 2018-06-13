package com.enjin.enjincoin.sdk.client.service.identities;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityField;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.UpdateIdentityData;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public interface SynchronousIdentitiesService {

    Response<GraphQLResponse<IdentitiesData>> getAllIdentitiesSync() throws IOException;

    Response<GraphQLResponse<IdentitiesData>> getIdentitiesSync(Integer id, String ethereumAddress) throws IOException;

    Response<GraphQLResponse<CreateIdentityData>> createIdentitySync(Integer id, String ethereumAddress, List<IdentityField> fields) throws IOException;

    Response<GraphQLResponse<UpdateIdentityData>> updateIdentitySync(Integer id, Integer appId, Integer userId,
                                                                     String ethereumAddress,
                                                                     List<IdentityField> fields) throws IOException;
}
