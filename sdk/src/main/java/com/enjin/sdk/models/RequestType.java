package com.enjin.sdk.models;

/**
 * Represents the transaction type when creating or updating a transaction.
 *
 * @see Request
 */
public enum RequestType {

    UNKNOWN,
    APPROVE,
    CREATE,
    MINT,
    SEND,
    SEND_ENJ,
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
    MESSAGE,
    ACCEPT_ASSIGNMENT,
    ASSIGN,

}
