package com.enjin.sdk.models.app;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.app.AppsService;

/**
 * An object class for deleting an application on the Trusted Platform.
 *
 * @see AppsService
 */
public class DeleteApp extends GraphQLRequest<DeleteApp> implements AppFragment<DeleteApp> {

    /**
     * The id of the application.
     *
     * @param id the app id
     * @return   this request
     */
    public DeleteApp id(int id) {
        set("id", id);
        return this;
    }

}
