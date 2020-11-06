package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request to obtain the access token for the application.
 *
 * @see com.enjin.sdk.models.AccessToken
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class AuthProject extends GraphQLRequest<AuthProject> {

    /**
     * Sole constructor.
     */
    public AuthProject() {
        super("enjin.sdk.project.AuthProject");
    }

    /**
     * Sets the application ID.
     *
     * @param appId the ID
     * @return this request for chaining
     */
    public AuthProject id(Integer appId) {
        return set("id", appId);
    }

    /**
     * Sets the secret.
     *
     * @param secret the secret
     * @return this request for chaining
     */
    public AuthProject secret(String secret) {
        return set("secret", secret);
    }

}
