package com.enjin.sdk.models.app;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.app.AppsService;

/**
 * An object class for getting an application from the Trusted Platform.
 *
 * @see AppsService
 */
public class GetApp extends PaginationRequest<GetApp> implements AppFragment<GetApp> {

    /**
     * The application id to filter by.
     *
     * @param id the app id
     * @return   this request
     */
    public GetApp id(int id) {
        set("id", id);
        return this;
    }

    /**
     * The application name to filter by.
     *
     * @param name the name of the app
     * @return     this request
     */
    public GetApp name(String name) {
        set("name", name);
        return this;
    }

}
