package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class SetUri
        extends GraphQLRequest<SetUri>
        implements TransactionFragmentArguments<SetUri>,
        TransactionRequestArguments<SetUri> {

    /**
     * TODO
     */
    public SetUri() {
        super("enjin.sdk.project.SetUri");
    }

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public SetUri tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * TODO
     * @param tokenIndex
     * @return
     */
    public SetUri tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * TODO
     * @param uri
     * @return
     */
    public SetUri uri(String uri) {
        return set("uri", uri);
    }

}
