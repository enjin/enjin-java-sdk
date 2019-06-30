package com.enjin.enjincoin.sdk.model.service.apps;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

public class DeleteApp extends GraphQLRequest<DeleteApp> {

    public DeleteApp id(int id) {
        withParameter("id", id);
        return this;
    }

}
