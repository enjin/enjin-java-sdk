package com.enjin.sdk.service.apps;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.apps.App;
import com.enjin.sdk.model.service.apps.CreateApp;
import com.enjin.sdk.model.service.apps.DeleteApp;
import com.enjin.sdk.model.service.apps.GetApp;
import com.enjin.sdk.model.service.apps.GetApps;
import com.enjin.sdk.model.service.apps.UnlinkApp;
import com.enjin.sdk.model.service.apps.UpdateApp;
import com.enjin.sdk.model.service.auth.AuthApp;
import com.enjin.sdk.model.service.auth.AuthTokens;

public interface SynchronousAppsService {

    HttpResponse<GraphQLResponse<List<App>>> getAppsSync(GetApps query);

    HttpResponse<GraphQLResponse<App>> getAppSync(GetApp query);

    HttpResponse<GraphQLResponse<App>> createAppSync(CreateApp query);

    HttpResponse<GraphQLResponse<App>> deleteAppSync(DeleteApp query);

    HttpResponse<GraphQLResponse<App>> updateAppSync(UpdateApp query);

    HttpResponse<GraphQLResponse<AuthTokens>> authAppSync(AuthApp query);

    HttpResponse<GraphQLResponse<App>> unlinkAppSync(UnlinkApp query);

}
