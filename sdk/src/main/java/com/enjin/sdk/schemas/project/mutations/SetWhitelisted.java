package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.inputs.Whitelisted;
import com.enjin.sdk.schemas.shared.fragments.inputs.TransactionRequestArguments;

/**
 * TODO
 */
public class SetWhitelisted
        extends GraphQLRequest<SetWhitelisted>
        implements TransactionRequestArguments<SetWhitelisted> {

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public SetWhitelisted tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * TODO
     * @param accountAddress
     * @return
     */
    public SetWhitelisted accountAddress(String accountAddress) {
        return set("accountAddress", accountAddress);
    }

    /**
     * TODO
     * @param whitelisted
     * @return
     */
    public SetWhitelisted whitelisted(Whitelisted whitelisted) {
        return set("whitelisted", whitelisted);
    }

    /**
     * TODO
     * @param whitelistedAddress
     * @return
     */
    public SetWhitelisted whitelistedAddress(String whitelistedAddress) {
        return set("whitelistedAddress", whitelistedAddress);
    }

    /**
     * TODO
     * @param on
     * @return
     */
    public SetWhitelisted on(boolean on) {
        return set("on", on);
    }

}
