package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TokenFragmentArguments;

/**
 * TODO
 */
public class GetToken
        extends GraphQLRequest<GetToken>
        implements TokenFragmentArguments<GetToken> {

    /**
     * TODO
     */
    public GetToken() {
        super("enjin.sdk.shared.GetToken");
    }

    /**
     * TODO
     * @param id
     * @return
     */
    public GetToken id(String id) {
        return set("id", id);
    }

}
