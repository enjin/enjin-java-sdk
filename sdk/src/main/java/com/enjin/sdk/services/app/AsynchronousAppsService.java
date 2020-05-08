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
import com.enjin.sdk.models.AccessToken;

/**
 * Asynchronous methods for querying and mutating applications.
 */
public interface AsynchronousAppsService {

    /**
     * Gets the applications that match the query parameters.
     *
     * @param query    the query
     * @param callback the callback
     */
    void getAppsAsync(GetApps query,
                      HttpCallback<GraphQLResponse<List<App>>> callback);

    /**
     * Gets the application that matches the query parameters.
     *
     * @param query    the query
     * @param callback the callback
     */
    void getAppAsync(GetApp query,
                     HttpCallback<GraphQLResponse<App>> callback);

    /**
     * Creates a new application.
     *
     * @param query    the query
     * @param callback the callback
     */
    void createAppAsync(CreateApp query,
                        HttpCallback<GraphQLResponse<App>> callback);

    /**
     * Deletes a application.
     *
     * @param query    the query
     * @param callback the callback
     */
    void deleteAppAsync(DeleteApp query,
                        HttpCallback<GraphQLResponse<App>> callback);

    /**
     * Updates a application.
     *
     * @param query    the query
     * @param callback the callback
     */
    void updateAppAsync(UpdateApp query,
                        HttpCallback<GraphQLResponse<App>> callback);

    /**
     * Gets a application's access tokens that matches the query parameters.
     *
     * @param query    the query
     * @param callback the callback
     */
    void authAppAsync(AuthApp query,
                      HttpCallback<GraphQLResponse<AccessToken>> callback);

    /**
     * Unlinks a wallet from a application.
     *
     * @param query    the query
     * @param callback the callback
     */
    void unlinkAppAsync(UnlinkApp query,
                        HttpCallback<GraphQLResponse<App>> callback);

}
