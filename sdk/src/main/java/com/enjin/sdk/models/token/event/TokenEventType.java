package com.enjin.sdk.models.token.event;

/**
 * Represent a type of token event.
 *
 * @see TokenEvent
 */
public enum TokenEventType {

    UNKNOWN_EVENT,
    CREATE,
    MELT,
    MINT,
    LOG,
    APPROVAL,
    APPROVAL_FOR_ALL,
    TRANSFER,
    TRANSFER_SINGLE,
    TRANSFER_BATCH,
    UPDATE_TRANSFER_FEE,
    UPDATE_MAX_TRANSFER_FEE,
    UPDATE_MELT_FEE,
    UPDATE_TRANSFERABLE,
    ASSIGN,
    ACCEPT_ASSIGNMENT,
    WHITELIST,
    CREATE_TRADE,
    COMPLETE_TRADE,
    CANCEL_TRADE,
    URI,
    NAME,
    INITIALIZE,
    RETIRE,
    DECIMALS,
    SYMBOL,
    DEPLOY_ERC_ADAPTER,
    MANAGER_UPDATE
}
