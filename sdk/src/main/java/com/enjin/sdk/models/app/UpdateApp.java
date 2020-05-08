package com.enjin.sdk.models.app;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.app.AppsService;

/**
 * An object class for updating an application on the Trusted Platform.
 *
 * @see AppsService
 */
public class UpdateApp extends GraphQLRequest<UpdateApp> implements AppFragment<UpdateApp> {

    /**
     * The application's id.
     *
     * @param id the app id
     * @return   this request
     */
    public UpdateApp id(Integer id) {
        set("id", id);
        return this;
    }

    /**
     * The new name for the application.
     *
     * @param name the new name for the app
     * @return     this request
     */
    public UpdateApp name(String name) {
        set("name", name);
        return this;
    }

    /**
     * The new description for the application.
     *
     * @param description the new description for the app
     * @return            this request
     */
    public UpdateApp description(String description) {
        set("description", description);
        return this;
    }

    /**
     * The new url for the application's image.
     *
     * @param image the new image url for the app
     * @return      this request
     */
    public UpdateApp image(String image) {
        set("image", image);
        return this;
    }

}
