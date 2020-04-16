package com.enjin.sdk.services.app;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.app.App;
import com.enjin.sdk.models.app.CreateApp;
import com.enjin.sdk.models.app.DeleteApp;
import com.enjin.sdk.models.app.GetApp;
import com.enjin.sdk.models.app.GetApps;
import com.enjin.sdk.models.app.UnlinkApp;
import com.enjin.sdk.models.app.UpdateApp;
import com.enjin.sdk.models.app.AuthApp;
import com.enjin.sdk.models.AccessToken;

public interface SynchronousAppsService {

    HttpResponse<GraphQLResponse<List<App>>> getAppsSync(GetApps query);

    HttpResponse<GraphQLResponse<App>> getAppSync(GetApp query);

    HttpResponse<GraphQLResponse<App>> createAppSync(CreateApp query);

    HttpResponse<GraphQLResponse<App>> deleteAppSync(DeleteApp query);

    HttpResponse<GraphQLResponse<App>> updateAppSync(UpdateApp query);

    HttpResponse<GraphQLResponse<AccessToken>> authAppSync(AuthApp query);

    HttpResponse<GraphQLResponse<App>> unlinkAppSync(UnlinkApp query);

}
