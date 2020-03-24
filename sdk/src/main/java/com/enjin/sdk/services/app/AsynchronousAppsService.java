package com.enjin.sdk.services.app;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.app.App;
import com.enjin.sdk.models.app.CreateApp;
import com.enjin.sdk.models.app.DeleteApp;
import com.enjin.sdk.models.app.GetApp;
import com.enjin.sdk.models.app.GetApps;
import com.enjin.sdk.models.app.UnlinkApp;
import com.enjin.sdk.models.app.UpdateApp;
import com.enjin.sdk.models.app.AuthApp;
import com.enjin.sdk.models.AuthTokens;

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
