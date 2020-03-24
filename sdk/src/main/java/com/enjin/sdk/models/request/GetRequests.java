package com.enjin.sdk.models.request;

import java.util.List;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.request.RequestsService;

/**
 * A builder for requests from the Trusted platform.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
public class GetRequests extends PaginationRequest<GetRequests> implements TransactionFragment<GetRequests> {

    /**
     * The request id.
     *
     * @param requestId the request id.
     *
     * @return the builder.
     */
    public GetRequests requestId(int requestId) {
        set("id", requestId);
        return this;
    }

    /**
     * The blockchain transaction id.
     *
     * @param transactionId the transaction id.
     *
     * @return the builder.
     */
    public GetRequests transactionId(String transactionId) {
        set("transactionId", transactionId);
        return this;
    }

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     *
     * @return the builder.
     */
    public GetRequests identityId(int identityId) {
        set("identityId", identityId);
        return this;
    }

    /**
     * The transaction type.
     *
     * @param type the transaction type.
     *
     * @return the builder.
     */
    public GetRequests transactionType(TransactionType type) {
        set("type", type);
        return this;
    }

    /**
     * The recipients identity id.
     *
     * @param recipientId the recipients identity id.
     *
     * @return the builder.
     */
    public GetRequests recipientId(int recipientId) {
        set("recipientId", recipientId);
        return this;
    }

    /**
     * The recipients ethereum address.
     *
     * @param recipientAddress the recipients ethereum address.
     *
     * @return the builder.
     */
    public GetRequests recipientAddress(String recipientAddress) {
        set("recipientAddress", recipientAddress);
        return this;
    }

    /**
     * The sender or recipients identity id.
     *
     * @param senderOrRecipientId the sender or recipients identity id.
     *
     * @return the builder.
     */
    public GetRequests senderOrRecipientIdentity(int senderOrRecipientId) {
        set("senderOrRecipientId", senderOrRecipientId);
        return this;
    }

    /**
     * The token id.
     *
     * @param tokenId the token id.
     *
     * @return the builder.
     */
    public GetRequests tokenId(String tokenId) {
        set("tokenId", tokenId);
        return this;
    }

    /**
     * The token value.
     *
     * @param value the token value.
     *
     * @return the builder.
     */
    public GetRequests value(String value) {
        set("value", value);
        return this;
    }

    /**
     * A list of states to match.
     *
     * @param stateIn a list of states to match.
     *
     * @return the builder.
     */
    public GetRequests stateMatchesAny(List<TransactionState> stateIn) {
        set("states", stateIn);
        return this;
    }

    /**
     * A list of states to match.
     *
     * @param stateIn a list of states to match.
     *
     * @return the builder.
     */
    public GetRequests stateMatchesAny(TransactionState... stateIn) {
        set("states", stateIn);
        return this;
    }

    /**
     * Whether the transactions can only broadcast.
     *
     * @return the builder.
     */
    public GetRequests canBroadcastOnly() {
        set("onlyBroadcastable", true);
        return this;
    }

}
