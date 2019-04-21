package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

public class DeleteIdentity extends GraphQLRequest.Builder {

    public DeleteIdentity withIdentityId(int id) {
        withParameter("id", id);
        return this;
    }

    public DeleteIdentity withUnlink(boolean unlink) {
        withParameter("unlink", unlink);
        return this;
    }

    public static DeleteIdentity unlink(int id) {
        return new DeleteIdentity().withIdentityId(id)
                                   .withUnlink(true);
    }

}
