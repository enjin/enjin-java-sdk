package com.enjin.sdk.model.service.apps;

import com.enjin.sdk.graphql.GraphQLRequest;

public class CreateApp extends GraphQLRequest<CreateApp> {

    public CreateApp name(String name) {
        withVariable("name", name);
        return this;
    }

    public CreateApp description(String description) {
        withVariable("description", description);
        return this;
    }

    public CreateApp image(String image) {
        withVariable("image", image);
        return this;
    }

}
