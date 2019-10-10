package com.enjin.sdk.service.apps;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.model.service.apps.App;
import com.enjin.sdk.model.service.apps.CreateApp;
import com.enjin.sdk.model.service.apps.DeleteApp;
import com.enjin.sdk.model.service.apps.GetApps;
import com.enjin.sdk.model.service.apps.UpdateApp;

public interface AsynchronousAppsService {

    void getAppsAsync(GetApps query,
                      HttpCallback<GraphQLResponse<List<App>>> callback);

    void createAppAsync(CreateApp query,
                        HttpCallback<GraphQLResponse<App>> callback);

    void deleteAppAsync(DeleteApp query,
                        HttpCallback<GraphQLResponse<App>> callback);

    void updateAppAsync(UpdateApp query,
                        HttpCallback<GraphQLResponse<App>> callback);

}
