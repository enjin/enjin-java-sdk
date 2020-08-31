package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.Melt;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for melting a item.
 *
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class MeltToken
        extends GraphQLRequest<MeltToken>
        implements TransactionRequestArguments<MeltToken> {

    /**
     * Sole constructor.
     */
    public MeltToken() {
        super("enjin.sdk.shared.MeltToken");
    }

    /**
     * Sets the melts to be performed.
     *
     * @param melts the melts
     * @return this request for chaining
     */
    public MeltToken melts(Melt... melts) {
        return set("melts", melts);
    }

}
