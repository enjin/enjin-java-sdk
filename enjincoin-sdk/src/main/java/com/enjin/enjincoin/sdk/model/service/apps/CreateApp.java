package com.enjin.enjincoin.sdk.model.service.apps;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

public class CreateApp extends GraphQLRequest<CreateApp> {

    public CreateApp name(String name) {
        withParameter("name", name);
        return this;
    }

    public CreateApp description(String description) {
        withParameter("description", description);
        return this;
    }

    public CreateApp image(String image) {
        withParameter("image", image);
        return this;
    }

}
