package com.enjin.sdk.model.service.requests;

/**
 * Represents the type of transaction when creating or updating a request.
 *
 * @author Evan Lindsay
 * @see CreateRequest
 * @see UpdateRequest
 */
public enum TransactionType {

    UNKNOWN,
    APPROVE,
    CREATE,
    MINT,
    SEND,
    ADVANCED_SEND,
    CREATE_TRADE,
    COMPLETE_TRADE,
    CANCEL_TRADE,
    MELT,
    UPDATE_NAME,
    SET_ITEM_URI,
    SET_WHITELISTED,
    SET_TRANSFERABLE,
    SET_MELT_FEE,
    DECREASE_MAX_MELT_FEE,
    SET_TRANSFER_FEE,
    DECREASE_MAX_TRANSFER_FEE,
    RELEASE_RESERVE,
    ADD_LOG,
    SET_APPROVAL_FOR_ALL,
    MANAGER_UPDATE,
    SET_DECIMALS,
    SET_SYMBOL,
    MESSAGE

}
