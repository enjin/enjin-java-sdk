package com.enjin.sdk.model.service.roles;

import java.util.Collection;

import com.enjin.sdk.graphql.GraphQLRequest;

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
