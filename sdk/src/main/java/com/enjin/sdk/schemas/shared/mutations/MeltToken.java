package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.Melt;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class MeltToken
        extends GraphQLRequest<MeltToken>
        implements TransactionRequestArguments<MeltToken> {

    /**
     * TODO
     */
    public MeltToken() {
        super("enjin.sdk.shared.MeltToken");
    }

    /**
     * TODO
     * @param melts
     * @return
     */
    public MeltToken melts(Melt... melts) {
        return set("melts", melts);
    }

}
