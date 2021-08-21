package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for sending a asset.
 *
 * @see AdvancedSendAsset
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class SendAsset
        extends GraphQLRequest<SendAsset>
        implements ProjectTransactionRequestArguments<SendAsset> {

    /**
     * Sole constructor.
     */
    public SendAsset() {
        super("enjin.sdk.project.SendAsset");
    }

    /**
     * Sets the wallet address of the recipient.
     *
     * @param recipientAddress the address
     * @return this request for chaining
     */
    public SendAsset recipientAddress(String recipientAddress) {
        return set("recipientAddress", recipientAddress);
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public SendAsset assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the index for non-fungible assets.
     *
     * @param assetIndex the index
     * @return this request for chaining
     */
    public SendAsset assetIndex(String assetIndex) {
        return set("assetIndex", assetIndex);
    }

    /**
     * Sets the amount to send.
     *
     * @param value the amount
     * @return this request for chaining
     */
    public SendAsset value(String value) {
        return set("value", value);
    }

    /**
     * Sets the data to forward with the transaction.
     *
     * @param data the data
     * @return this request for chaining
     */
    public SendAsset data(String data) {
        return set("data", data);
    }

}
