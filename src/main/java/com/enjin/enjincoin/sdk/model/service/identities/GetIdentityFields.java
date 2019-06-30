package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.model.service.PaginationRequest;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GetIdentityFields extends PaginationRequest<GetIdentityFields> {

    public GetIdentityFields withId(int id) {
        withParameter("id", id);
        return this;
    }

    public GetIdentityFields withKey(String key) {
        withParameter("key", key);
        return this;
    }

    public GetIdentityFields withSearchable(int searchable) {
        withParameter("searchable", searchable);
        return this;
    }

    public GetIdentityFields withDisplayable(int displayable) {
        withParameter("displayable", displayable);
        return this;
    }

    public GetIdentityFields withUnique(int unique) {
        withParameter("unique", unique);
        return this;
    }

}
