package com.enjin.sdk.model.service.apps;

import com.enjin.sdk.model.service.PaginationRequest;

public class GetApps extends PaginationRequest<GetApps> {

    public GetApps id(int id) {
        withVariable("id", id);
        return this;
    }

    public GetApps name(String name) {
        withVariable("name", name);
        return this;
    }

}
