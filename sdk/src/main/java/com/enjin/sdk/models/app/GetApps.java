package com.enjin.sdk.models.app;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.app.AppsService;

/**
 * An object class for getting applications from the Trusted Platform.
 *
 * @see AppsService
 */
public class GetApps extends PaginationRequest<GetApps> implements AppFragment<GetApps> {

    /**
     * The application id to filer by.
     *
     * @param id the app id
     * @return   this request
     */
    public GetApps id(int id) {
        set("id", id);
        return this;
    }

    /**
     * The application name to filter by.
     *
     * @param name the app name
     * @return     this request
     */
    public GetApps name(String name) {
        set("name", name);
        return this;
    }

}
