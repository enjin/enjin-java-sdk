package com.enjin.sdk.models.app;

import com.enjin.sdk.models.PaginationRequest;

public class GetApp extends PaginationRequest<GetApp> implements AppFragment<GetApp> {

    public GetApp id(int id) {
        set("id", id);
        return this;
    }

    public GetApp name(String name) {
        set("name", name);
        return this;
    }

}
