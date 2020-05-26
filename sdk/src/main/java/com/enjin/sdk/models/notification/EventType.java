package com.enjin.sdk.models.notification;

import com.enjin.sdk.services.notification.EventFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the type of notification received.
 *
 * @author Evan Lindsay
 * @see NotificationEvent
 */
public enum EventType {

    APP_CREATED("EnjinCloud\\Events\\AppCreated", "app"),
    APP_DELETED("EnjinCloud\\Events\\AppDeleted", "app"),
    APP_LINKED("EnjinCloud\\Events\\AppLinked", "app", "wallet"),
    APP_LOCKED("EnjinCloud\\Events\\AppLocked", "app"),
    APP_UNLINKED("EnjinCloud\\Events\\AppUnlinked", "app", "wallet"),
    APP_UNLOCKED("EnjinCloud\\Events\\AppUnlocked", "app"),
    APP_UPDATED("EnjinCloud\\Events\\AppUpdated", "app"),
    BLOCKCHAIN_LOG_PROCESSED("EnjinCloud\\Events\\BlockchainLogProcessed", "app", "identity", "token", "wallet"),
    IDENTITY_CREATED("EnjinCloud\\Events\\IdentityCreated", "app", "identity", "user"),
    IDENTITY_DELETED("EnjinCloud\\Events\\IdentityDeleted", "app", "identity", "user"),
    IDENTITY_LINKED("EnjinCloud\\Events\\IdentityLinked", "app", "identity", "user", "wallet"),
    IDENTITY_UNLINKED("EnjinCloud\\Events\\IdentityUnlinked", "app", "identity", "user", "wallet"),
    IDENTITY_UPDATED("EnjinCloud\\Events\\IdentityUpdated", "app", "identity", "user"),
    MESSAGE_PROCESSED("EnjinCloud\\Events\\MessageProcessed", "app", "identity", "token", "wallet"),
    TOKEN_CREATED("EnjinCloud\\Events\\TokenCreated", "app", "token", "wallet"),
    TOKEN_MELTED("EnjinCloud\\Events\\TokenMelted", "app", "token", "wallet"),
    TOKEN_MINTED("EnjinCloud\\Events\\TokenMinted", "app", "token", "wallet"),
    TOKEN_TRANSFERRED("EnjinCloud\\Events\\TokenTransferred", "app", "token", "wallet"),
    TOKEN_UPDATED("EnjinCloud\\Events\\TokenUpdated", "app", "token", "wallet"),
    TRADE_COMPLETED("EnjinCloud\\Events\\TradeCompleted", "app", "token", "wallet"),
    TRADE_CREATED("EnjinCloud\\Events\\TradeCreated", "app", "token", "wallet"),
    TRANSACTION_BROADCAST("EnjinCloud\\Events\\TransactionBroadcast", "app", "identity", "token", "wallet"),
    TRANSACTION_CANCELED("EnjinCloud\\Events\\TransactionCanceled", "app", "identity", "token", "wallet"),
    TRANSACTION_DROPPED("EnjinCloud\\Events\\TransactionDropped", "app", "identity", "token", "wallet"),
    TRANSACTION_EXECUTED("EnjinCloud\\Events\\TransactionExecuted", "app", "identity", "token", "wallet"),
    TRANSACTION_FAILED("EnjinCloud\\Events\\TransactionFailed", "app", "identity", "token", "wallet"),
    TRANSACTION_PENDING("EnjinCloud\\Events\\TransactionPending", "app", "identity", "token", "wallet"),
    TRANSACTION_PROCESSING("EnjinCloud\\Events\\TransactionProcessing", "app", "identity", "token", "wallet"),
    TRANSACTION_UPDATED("EnjinCloud\\Events\\TransactionUpdated", "app", "identity", "token", "wallet");

    private final String eventType;
    private final String[] channelTypes;

    /**
     * Sole constructor.
     *
     * @param eventType the type of the enum
     */
    EventType(String eventType, String... channelTypes) {
        this.eventType = eventType;
        this.channelTypes = channelTypes;
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
     * @param filter filter being processed
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
    public static EventType getFromName(String name) {
        EventType type;

        try {
            type = valueOf(name);
        } catch (IllegalArgumentException e) {
            type = null;
        }

        return type;
    }

    public static List<EventType> filterByChannelTypes(String channel) {
        List<EventType> types = new ArrayList<>();
        for (EventType type : values()) {
            for (String key : type.channelTypes) {
                if (channel.toLowerCase().contains(key)) {
                    types.add(type);
                    break;
                }
            }
        }
        return types;
    }
}
