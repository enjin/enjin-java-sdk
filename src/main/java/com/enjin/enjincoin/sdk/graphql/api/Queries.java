package com.enjin.enjincoin.sdk.graphql.api;

public class Queries {

    // Requests
    public static final String CREATE_REQUEST = "mutation createRequest {\n" +
            "    CreateEnjinRequest(%s) {\n" +
            "        id,\n" +
            "        transaction_id,\n" +
            "        app_id,\n" +
            "        identity_id,\n" +
            "        type,\n" +
            "        recipient_id,\n" +
            "        recipient_address,\n" +
            "        token_id,\n" +
            "        encoded_data,\n" +
            "        signed_transaction,\n" +
            "        signed_backup_transaction,\n" +
            "        signed_cancel_transaction,\n" +
            "        nonce,\n" +
            "        retry_state,\n" +
            "        state,\n" +
            "        accepted\n" +
            "    }\n" +
            "}";
    public static final String GET_ALL_REQUESTS = "query getAllRequests {\n" +
            "    EnjinTransactions {\n" +
            "        id,\n" +
            "        transaction_id,\n" +
            "        app_id,\n" +
            "        identity_id,\n" +
            "        type,\n" +
            "        recipient_id,\n" +
            "        recipient_address,\n" +
            "        token_id,\n" +
            "        encoded_data,\n" +
            "        signed_transaction,\n" +
            "        signed_backup_transaction,\n" +
            "        signed_cancel_transaction,\n" +
            "        nonce,\n" +
            "        retry_state,\n" +
            "        state,\n" +
            "        accepted\n" +
            "    }\n" +
            "}";
    public static final String GET_REQUESTS = "query getRequests {\n" +
            "    EnjinTransactions(%s) {\n" +
            "        id,\n" +
            "        transaction_id,\n" +
            "        app_id,\n" +
            "        identity_id,\n" +
            "        type,\n" +
            "        recipient_id,\n" +
            "        recipient_address,\n" +
            "        token_id,\n" +
            "        encoded_data,\n" +
            "        signed_transaction,\n" +
            "        signed_backup_transaction,\n" +
            "        signed_cancel_transaction,\n" +
            "        nonce,\n" +
            "        retry_state,\n" +
            "        state,\n" +
            "        accepted\n" +
            "    }\n" +
            "}";
    public static final String UPDATE_REQUEST = "mutation updateRequest {\n" +
            "    UpdateEnjinRequest(%s) {\n" +
            "        id,\n" +
            "        transaction_id,\n" +
            "        app_id,\n" +
            "        identity_id,\n" +
            "        type,\n" +
            "        recipient_id,\n" +
            "        recipient_address,\n" +
            "        token_id,\n" +
            "        encoded_data,\n" +
            "        signed_transaction,\n" +
            "        signed_backup_transaction,\n" +
            "        signed_cancel_transaction,\n" +
            "        nonce,\n" +
            "        retry_state,\n" +
            "        state,\n" +
            "        accepted\n" +
            "    }\n" +
            "}";

}
