package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request to set the metadata URI of an item.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class SetUri
        extends GraphQLRequest<SetUri>
        implements TransactionRequestArguments<SetUri> {

    /**
     * Sole constructor.
     */
    public SetUri() {
        super("enjin.sdk.project.SetUri");
    }

    /**
     * Sets the token (item) ID.
     *
     * @param tokenId the ID
     * @return this request for chaining
     */
    public SetUri tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * Sets the index for non-fungible items.
     *
     * @param tokenIndex the index
     * @return this request for chaining
     */
    public SetUri tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * Sets the new URI for the item's metadata.
     *
     * @param uri the new URI
     * @return this request for chaining
     */
    public SetUri uri(String uri) {
        return set("uri", uri);
    }

}
