package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;
import com.enjin.sdk.schemas.shared.arguments.WalletFragmentArguments;

/**
 * Request for getting player wallets.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class GetWallets
        extends GraphQLRequest<GetWallets>
        implements WalletFragmentArguments<GetWallets>,
        PaginationArguments<GetWallets> {

    /**
     * Sole constructor.
     */
    public GetWallets() {
        super("enjin.sdk.project.GetWallets");
    }

    /**
     * Sets the user IDs owning the wallets to get.
     *
     * @param userIds the IDs
     * @return this request for chaining
     */
    public GetWallets userIds(String... userIds) {
        return set("userIds", userIds);
    }

    /**
     * Sets the Ethereum addresses of the wallets to get.
     *
     * @param ethAddresses the addresses
     * @return this request for chaining
     */
    public GetWallets ethAddresses(String... ethAddresses) {
        return set("ethAddresses", ethAddresses);
    }

}
