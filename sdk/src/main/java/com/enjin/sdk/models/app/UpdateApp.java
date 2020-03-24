package com.enjin.sdk.models.app;

import com.enjin.sdk.graphql.GraphQLRequest;

public class UpdateApp extends GraphQLRequest<UpdateApp> implements AppFragment<UpdateApp> {

    public UpdateApp id(Integer id) {
        set("id", id);
        return this;
    }

    public UpdateApp name(String name) {
        set("name", name);
        return this;
    }

    public UpdateApp description(String description) {
        set("description", description);
        return this;
    }

    public UpdateApp image(String image) {
        set("image", image);
        return this;
    }

}
