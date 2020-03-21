package com.enjin.sdk.service.apps;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.model.service.apps.App;
import com.enjin.sdk.model.service.apps.CreateApp;
import com.enjin.sdk.model.service.apps.DeleteApp;
import com.enjin.sdk.model.service.apps.GetApp;
import com.enjin.sdk.model.service.apps.GetApps;
import com.enjin.sdk.model.service.apps.UnlinkApp;
import com.enjin.sdk.model.service.apps.UpdateApp;
import com.enjin.sdk.model.service.auth.AuthApp;
import com.enjin.sdk.model.service.auth.AuthTokens;

public interface AsynchronousAppsService {

    void getAppsAsync(GetApps query,
                      HttpCallback<GraphQLResponse<List<App>>> callback);

    void getAppAsync(GetApp query,
                     HttpCallback<GraphQLResponse<App>> callback);

    void createAppAsync(CreateApp query,
                        HttpCallback<GraphQLResponse<App>> callback);

    void deleteAppAsync(DeleteApp query,
                        HttpCallback<GraphQLResponse<App>> callback);

    void updateAppAsync(UpdateApp query,
                        HttpCallback<GraphQLResponse<App>> callback);

    void authAppAsync(AuthApp query,
                      HttpCallback<GraphQLResponse<AuthTokens>> callback);

    void unlinkAppAsync(UnlinkApp query,
                        HttpCallback<GraphQLResponse<App>> callback);

}
