package com.enjin.sdk.models.app;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.app.AppsService;

/**
 * An object class for creating an application on the Trusted Platform.
 *
 * @see AppsService
 */
public class CreateApp extends GraphQLRequest<CreateApp> implements AppFragment<CreateApp> {

    /**
     * The name of the application.
     *
     * @param name the name of the app
     * @return     this request
     */
    public CreateApp name(String name) {
        set("name", name);
        return this;
    }

    /**
     * The application description.
     *
     * @param description the description of the app
     * @return            this request
     */
    public CreateApp description(String description) {
        set("description", description);
        return this;
    }

    /**
     * The url to be used for the application's image.
     *
     * @param image the url for the image of the app
     * @return      this request
     */
    public CreateApp image(String image) {
        set("image", image);
        return this;
    }

}
