package com.enjin.enjincoin.sdk.model.service.roles;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

import java.util.Collection;

public class CreateRole extends GraphQLRequest<CreateRole> {

    public CreateRole name(String name) {
        withParameter("name", name);
        return this;
    }

    public CreateRole permissions(String... permissions) {
        withParameter("permissions", permissions);
        return this;
    }

    public CreateRole permissions(Collection<String> permissions) {
        withParameter("permissions", permissions);
        return this;
    }

}
