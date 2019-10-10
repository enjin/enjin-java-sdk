package com.enjin.sdk.model.service.apps;

import com.enjin.sdk.model.service.PaginationRequest;

public class GetApps extends PaginationRequest<GetApps> {

    public GetApps id(int id) {
        withParameter("id", id);
        return this;
    }

    public GetApps name(String name) {
        withParameter("name", name);
        return this;
    }

    public GetApps me() {
        withParameter("me", true);
        return this;
    }

}
