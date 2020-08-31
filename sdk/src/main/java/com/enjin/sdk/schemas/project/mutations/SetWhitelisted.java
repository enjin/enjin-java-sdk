package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.Whitelisted;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for setting an item's whitelist.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class SetWhitelisted
        extends GraphQLRequest<SetWhitelisted>
        implements TransactionRequestArguments<SetWhitelisted> {

    /**
     * Sole constructor.
     */
    public SetWhitelisted() {
        super("enjin.sdk.project.SetWhitelisted");
    }

    /**
     * Sets the token (item) ID.
     *
     * @param tokenId the ID
     * @return this request for chaining
     */
    public SetWhitelisted tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * Sets the account address to be added to the whitelist.
     *
     * @param accountAddress the address
     * @return this request for chaining
     */
    public SetWhitelisted accountAddress(String accountAddress) {
        return set("accountAddress", accountAddress);
    }

    /**
     * Sets the whitelisted setting for the account.
     *
     * @param whitelisted the setting
     * @return this request for chaining
     */
    public SetWhitelisted whitelisted(Whitelisted whitelisted) {
        return set("whitelisted", whitelisted);
    }

    /**
     * Sets the specified address for sending or receiving.
     *
     * @param whitelistedAddress the address
     * @return this request for chaining
     */
    public SetWhitelisted whitelistedAddress(String whitelistedAddress) {
        return set("whitelistedAddress", whitelistedAddress);
    }

    /**
     * Sets whether the whitelist setting is on or off.
     *
     * @param on the setting
     * @return this request for chaining
     */
    public SetWhitelisted on(Boolean on) {
        return set("on", on);
    }

}
