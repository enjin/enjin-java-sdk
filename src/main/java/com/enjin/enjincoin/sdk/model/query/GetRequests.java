package com.enjin.enjincoin.sdk.model.query;

import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.service.requests.vo.TransactionState;
import com.enjin.enjincoin.sdk.service.requests.vo.TransactionType;

import java.util.List;

public class GetRequests extends GraphQLRequest.Builder {

    public GetRequests withRequestId(int requestId) {
        withParameter("id", requestId);
        return this;
    }

    public GetRequests withTransactionId(String transactionId) {
        withParameter("transaction_id", transactionId);
        return this;
    }

    public GetRequests withIdentityId(int identityId) {
        withParameter("identity_id", identityId);
        return this;
    }

    public GetRequests withType(TransactionType type) {
        withParameter("type", type);
        return this;
    }

    public GetRequests withRecipientId(int recipientId) {
        withParameter("recipient_id", recipientId);
        return this;
    }

    public GetRequests withRecipientAddress(String recipientAddress) {
        withParameter("recipient_address", recipientAddress);
        return this;
    }

    public GetRequests withSenderOrRecipientId(int senderOrRecipientId) {
        withParameter("sender_or_recipient_id", senderOrRecipientId);
        return this;
    }

    public GetRequests withTokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

    public GetRequests withValue(String value) {
        withParameter("value", value);
        return this;
    }

    public GetRequests withState(TransactionState state) {
        withParameter("state", state);
        return this;
    }

    public GetRequests withStateIn(List<TransactionState> stateIn) {
        withParameter("state_in", stateIn);
        return this;
    }

    public GetRequests withStateIn(TransactionState... stateIn) {
        withParameter("state_in", stateIn);
        return this;
    }

    public GetRequests withCanBroadcastOnly(boolean canBroadcastOnly) {
        withParameter("can_broadcast_only", canBroadcastOnly);
        return this;
    }

}
