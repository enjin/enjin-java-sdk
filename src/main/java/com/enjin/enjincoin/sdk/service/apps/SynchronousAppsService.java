package com.enjin.enjincoin.sdk.service.apps;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.model.service.apps.App;
import com.enjin.enjincoin.sdk.model.service.apps.CreateApp;
import com.enjin.enjincoin.sdk.model.service.apps.DeleteApp;
import com.enjin.enjincoin.sdk.model.service.apps.GetApps;
import com.enjin.enjincoin.sdk.model.service.apps.UpdateApp;

import java.io.IOException;
import java.util.List;

public interface SynchronousAppsService {

    HttpResponse<GraphQLResponse<List<App>>> getIdentitiesSync(GetApps query) throws IOException;

    HttpResponse<GraphQLResponse<App>> createIdentitySync(CreateApp query) throws IOException;

    HttpResponse<GraphQLResponse<App>> deleteIdentitySync(DeleteApp query) throws IOException;

    HttpResponse<GraphQLResponse<App>> updateIdentitySync(UpdateApp query) throws IOException;

}
