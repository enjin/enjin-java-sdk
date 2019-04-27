package com.enjin.enjincoin.sdk.model.service.requests;

/**
 * Represents the type of transaction when creating or updating a request.
 *
 * @author Evan Lindsay
 * @see CreateRequest
 * @see UpdateRequest
 */
public enum TransactionType {

    APPROVE,
    CREATE,
    MINT,
    BUY,
    SELL,
    SEND,
    ADVANCED_SEND,
    USE,
    CREATE_TRADE,
    COMPLETE_TRADE,
    MELT,
    SET_ITEM_URI,
    SET_WHITELISTED,
    UPDATE_NAME,
    SET_TRANSFERABLE,
    SET_MELT_FEE,
    DECREASE_MAX_MELT_FEE,
    SET_TRANSFER_FEE,
    DECREASE_MAX_TRANSFER_FEE,
    ADD_LOG,
    BATCH_APPROVE,
    SET_APPROVAL,
    SET_APPROVAL_FOR_ALL,
    MESSAGE

}
