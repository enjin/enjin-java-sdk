package com.enjin.sdk.model.service.apps;

import com.enjin.sdk.model.service.PaginationRequest;

public class GetApp extends PaginationRequest<GetApp> {

    public GetApp id(int id) {
        withParameter("id", id);
        return this;
    }

    public GetApp name(String name) {
        withParameter("name", name);
        return this;
    }

}
