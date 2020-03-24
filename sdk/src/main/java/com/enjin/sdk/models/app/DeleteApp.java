package com.enjin.sdk.models.app;

import com.enjin.sdk.graphql.GraphQLRequest;

public class DeleteApp extends GraphQLRequest<DeleteApp> implements AppFragment<DeleteApp> {

    public DeleteApp id(int id) {
        set("id", id);
        return this;
    }

}
