package com.enjin.sdk.models.app;

import com.enjin.sdk.models.PaginationRequest;

public class GetApps extends PaginationRequest<GetApps> implements AppFragment<GetApps> {

    public GetApps id(int id) {
        set("id", id);
        return this;
    }

    public GetApps name(String name) {
        set("name", name);
        return this;
    }

}
