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

/**
 * Synchronous methods for querying and mutating applications.
 */
public interface SynchronousAppsService {

    /**
     * Gets the applications that match the query parameters.
     *
     * @param query the query
     * @return      the response
     */
    HttpResponse<GraphQLResponse<List<App>>> getAppsSync(GetApps query);

    /**
     * Gets the application that matches the query parameters.
     *
     * @param query the query
     * @return      the response
     */
    HttpResponse<GraphQLResponse<App>> getAppSync(GetApp query);

    /**
     * Creates a new application.
     *
     * @param query the query
     * @return      the response
     */
    HttpResponse<GraphQLResponse<App>> createAppSync(CreateApp query);

    /**
     * Deletes a application.
     *
     * @param query the query
     * @return      the response
     */
    HttpResponse<GraphQLResponse<App>> deleteAppSync(DeleteApp query);

    /**
     * Updates a application.
     *
     * @param query the query
     * @return      the response
     */
    HttpResponse<GraphQLResponse<App>> updateAppSync(UpdateApp query);

    /**
     * Gets a application's access tokens that matches the query parameters.
     *
     * @param query the query
     * @return      the response
     */
    HttpResponse<GraphQLResponse<AccessToken>> authAppSync(AuthApp query);

    /**
     * Unlinks a wallet from a application.
     *
     * @param query the query
     * @return      the response
     */
    HttpResponse<GraphQLResponse<App>> unlinkAppSync(UnlinkApp query);

}
