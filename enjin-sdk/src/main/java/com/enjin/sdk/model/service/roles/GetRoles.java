package com.enjin.sdk.model.service.roles;

import com.enjin.sdk.model.service.PaginationRequest;

public class GetRoles extends PaginationRequest<GetRoles> {

    public GetRoles id(int id) {
        withParameter("id", id);
        return this;
    }

    public GetRoles name(String name) {
        withParameter("name", name);
        return this;
    }

}
