package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

import java.math.BigInteger;

public class DeleteIdentity extends GraphQLRequest.Builder {

    public DeleteIdentity withIdentityId(BigInteger id) {
        withParameter("id", id);
        return this;
    }

    public DeleteIdentity withUnlink(boolean unlink) {
        withParameter("unlink", unlink);
        return this;
    }

    public static DeleteIdentity unlink(BigInteger id) {
        return new DeleteIdentity().withIdentityId(id)
                                   .withUnlink(true);
    }

}
