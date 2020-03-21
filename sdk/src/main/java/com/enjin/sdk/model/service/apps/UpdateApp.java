package com.enjin.sdk.model.service.apps;

import com.enjin.sdk.graphql.GraphQLRequest;

public class UpdateApp extends GraphQLRequest<UpdateApp> {

    public UpdateApp id(Integer id) {
        withVariable("id", id);
        return this;
    }

    public UpdateApp name(String name) {
        withVariable("name", name);
        return this;
    }

    public UpdateApp description(String description) {
        withVariable("description", description);
        return this;
    }

    public UpdateApp image(String image) {
        withVariable("image", image);
        return this;
    }

    public UpdateApp generateSecret(boolean secret) {
        withVariable("secret", secret);
        return this;
    }

    public UpdateApp revokeSecret(boolean revoke) {
        withVariable("revoke", revoke);
        return this;
    }

}
