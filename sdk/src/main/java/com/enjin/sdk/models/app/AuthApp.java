package com.enjin.sdk.models.app;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.app.AppsService;

/**
 * An object class for getting an application's access token from the Trusted Platform.
 *
 * @see AppsService
 */
public class AuthApp extends GraphQLRequest<AuthApp> {

    /**
     * The application id.
     *
     * @param appId the app id
     * @return      this request
     */
    public AuthApp id(Integer appId) {
        set("id", appId);
        return this;
    }

    /**
     * The application secret.
     *
     * @param secret the app secret
     * @return       this request
     */
    public AuthApp secret(String secret) {
        set("secret", secret);
        return this;
    }

}
