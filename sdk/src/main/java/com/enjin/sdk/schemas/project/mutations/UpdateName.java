package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class UpdateName
        extends GraphQLRequest<UpdateName>
        implements TransactionRequestArguments<UpdateName> {

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public UpdateName tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * TODO
     * @param tokenIndex
     * @return
     */
    public UpdateName tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * TODO
     * @param name
     * @return
     */
    public UpdateName name(String name) {
        return set("name", name);
    }

}
