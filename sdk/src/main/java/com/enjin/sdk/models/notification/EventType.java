package com.enjin.sdk.models.notification;

import com.enjin.sdk.services.notification.EventFilter;

/**
 * Represent the type of notification received.
 *
 * @author Evan Lindsay
 * @see NotificationEvent
 */
public enum EventType {

    UNKNOWN_EVENT("unknown"),
    APP_CREATED("EnjinCloud\\Events\\AppCreated"),
    APP_DELETED("EnjinCloud\\Events\\AppDeleted"),
    APP_LINKED("EnjinCloud\\Events\\AppLinked"),
    APP_LOCKED("EnjinCloud\\Events\\AppLocked"),
    APP_UNLINKED("EnjinCloud\\Events\\AppUnlinked"),
    APP_UNLOCKED("EnjinCloud\\Events\\AppUnlocked"),
    APP_UPDATED("EnjinCloud\\Events\\AppUpdated"),
    BLOCKCHAIN_LOG_PROCESSED("EnjinCloud\\Events\\BlockchainLogProcessed"),
    IDENTITY_CREATED("EnjinCloud\\Events\\IdentityCreated"),
    IDENTITY_DELETED("EnjinCloud\\Events\\IdentityDeleted"),
    IDENTITY_LINKED("EnjinCloud\\Events\\IdentityLinked"),
    IDENTITY_UNLINKED("EnjinCloud\\Events\\IdentityUnlinked"),
    IDENTITY_UPDATED("EnjinCloud\\Events\\IdentityUpdated"),
    MESSAGE_PROCESSED("EnjinCloud\\Events\\MessageProcessed"),
    PLAN_CHANGED("EnjinCloud\\Events\\PlanChanged"),
    TOKEN_CREATED("EnjinCloud\\Events\\TokenCreated"),
    TOKEN_MELTED("EnjinCloud\\Events\\TokenMelted"),
    TOKEN_MINTED("EnjinCloud\\Events\\TokenMinted"),
    TOKEN_TRANSFERRED("EnjinCloud\\Events\\TokenTransferred"),
    TOKEN_UPDATED("EnjinCloud\\Events\\TokenUpdated"),
    TRADE_COMPLETED("EnjinCloud\\Events\\TradeCompleted"),
    TRADE_CREATED("EnjinCloud\\Events\\TradeCreated"),
    TRANSACTION_BROADCAST("EnjinCloud\\Events\\TransactionBroadcast"),
    TRANSACTION_CANCELED("EnjinCloud\\Events\\TransactionCanceled"),
    TRANSACTION_DROPPED("EnjinCloud\\Events\\TransactionDropped"),
    TRANSACTION_EXECUTED("EnjinCloud\\Events\\TransactionExecuted"),
    TRANSACTION_FAILED("EnjinCloud\\Events\\TransactionFailed"),
    TRANSACTION_PENDING("EnjinCloud\\Events\\TransactionPending"),
    TRANSACTION_PROCESSING("EnjinCloud\\Events\\TransactionProcessing"),
    TRANSACTION_UPDATED("EnjinCloud\\Events\\TransactionUpdated");

    private final String eventType;

    EventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * Method to get the eventType.
     *
     * @return String
     */
    public String getEventType() {
        return this.eventType;
    }

    /**
     * Checks if this type is value in the given filter.
     *
     * @param filter - filter being processed
     *
     * @return boolean
     */
    public boolean in(EventFilter filter) {
        if (filter != null) {
            return this.in(filter.value());
        }

        return false;
    }

    /**
     * Check if this type is the current type.
     *
     * @param types to check
     *
     * @return boolean
     */
    public boolean in(EventType... types) {
        for (EventType type : types) {
            if (this == type) {
                return true;
            }
        }

        return false;
    }

    /**
     * Method to get the correct enum value.
     *
     * @param name to get enum for
     *
     * @return NotificationType
     */
    public static EventType valueOfEnum(String name) {
        EventType type;

        try {
            type = valueOf(name);
        } catch (IllegalArgumentException e) {
            type = UNKNOWN_EVENT;
        }

        return type;
    }
}
