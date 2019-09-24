package com.enjin.enjincoin.sdk.service.apps;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.model.service.apps.App;
import com.enjin.enjincoin.sdk.model.service.apps.CreateApp;
import com.enjin.enjincoin.sdk.model.service.apps.DeleteApp;
import com.enjin.enjincoin.sdk.model.service.apps.GetApps;
import com.enjin.enjincoin.sdk.model.service.apps.UpdateApp;

import java.util.List;

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
