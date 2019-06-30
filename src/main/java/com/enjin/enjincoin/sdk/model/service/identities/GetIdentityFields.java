package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.model.service.PaginationRequest;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GetIdentityFields extends PaginationRequest<GetIdentityFields> {

    public GetIdentityFields id(int id) {
        withParameter("id", id);
        return this;
    }

    public GetIdentityFields key(String key) {
        withParameter("key", key);
        return this;
    }

    public GetIdentityFields searchable() {
        withParameter("searchable", true);
        return this;
    }

    public GetIdentityFields displayable() {
        withParameter("displayable", true);
        return this;
    }

    public GetIdentityFields unique() {
        withParameter("unique", true);
        return this;
    }

}
