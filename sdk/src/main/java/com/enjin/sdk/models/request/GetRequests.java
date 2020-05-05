package com.enjin.sdk.models.request;

import java.util.List;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.request.RequestsService;

/**
 * An object class for requests from the Trusted Platform.
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
     * @return this request.
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
     * @return this request.
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
     * @return this request.
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
     * @return this request.
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
     * @return this request.
     */
    public GetRequests recipientId(int recipientId) {
        set("recipientId", recipientId);
        return this;
    }

    /**
     * The recipient's Ethereum address.
     *
     * @param recipientAddress the recipient's Ethereum address.
     *
     * @return this request.
     */
    public GetRequests recipientAddress(String recipientAddress) {
        set("recipientAddress", recipientAddress);
        return this;
    }

    /**
     * The sender or recipient's identity id.
     *
     * @param senderOrRecipientId the sender or recipient's identity id.
     *
     * @return this request.
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
     * @return this request.
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
     * @return this request.
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
     * @return this request.
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
     * @return this request.
     */
    public GetRequests stateMatchesAny(TransactionState... stateIn) {
        set("states", stateIn);
        return this;
    }

    /**
     * Whether the transactions can only broadcast.
     *
     * @return this request.
     */
    public GetRequests canBroadcastOnly() {
        set("onlyBroadcastable", true);
        return this;
    }

}
