package com.enjin.sdk.models.app;

import com.enjin.sdk.graphql.GraphQLRequest;

public class CreateApp extends GraphQLRequest<CreateApp> implements AppFragment<CreateApp> {

    public CreateApp name(String name) {
        set("name", name);
        return this;
    }

    public CreateApp description(String description) {
        set("description", description);
        return this;
    }

    public CreateApp image(String image) {
        set("image", image);
        return this;
    }

}
