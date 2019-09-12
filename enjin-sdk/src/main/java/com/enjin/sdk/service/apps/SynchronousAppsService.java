package com.enjin.sdk.service.apps;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.apps.App;
import com.enjin.sdk.model.service.apps.CreateApp;
import com.enjin.sdk.model.service.apps.DeleteApp;
import com.enjin.sdk.model.service.apps.GetApps;
import com.enjin.sdk.model.service.apps.UpdateApp;

public interface SynchronousAppsService {

    HttpResponse<GraphQLResponse<List<App>>> getAppsSync(GetApps query) throws IOException;

    HttpResponse<GraphQLResponse<App>> createAppSync(CreateApp query) throws IOException;

    HttpResponse<GraphQLResponse<App>> deleteAppSync(DeleteApp query) throws IOException;

    HttpResponse<GraphQLResponse<App>> updateAppSync(UpdateApp query) throws IOException;

}
