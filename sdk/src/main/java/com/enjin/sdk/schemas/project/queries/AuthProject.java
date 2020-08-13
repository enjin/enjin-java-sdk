package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * TODO
 */
public class AuthProject extends GraphQLRequest<AuthProject> {

    /**
     * TODO
     */
    public AuthProject() {
        super("enjin.sdk.project.AuthProject");
    }

    /**
     * TODO
     * @param appId
     * @return
     */
    public AuthProject id(String appId) {
        return set("id", appId);
    }

    /**
     * TODO
     * @param secret
     * @return
     */
    public AuthProject secret(String secret) {
        return set("secret", secret);
    }

}
