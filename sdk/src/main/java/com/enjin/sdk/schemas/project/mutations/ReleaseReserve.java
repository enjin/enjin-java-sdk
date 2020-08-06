package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class ReleaseReserve
        extends GraphQLRequest<ReleaseReserve>
        implements TransactionFragmentArguments<ReleaseReserve>,
        TransactionRequestArguments<ReleaseReserve> {

    /**
     * TODO
     */
    public ReleaseReserve() {
        super("enjin.sdk.project.ReleaseReserve");
    }

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public ReleaseReserve tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public ReleaseReserve value(String value) {
        return set("value", value);
    }

}
