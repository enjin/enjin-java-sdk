package com.enjin.sdk.models;

import com.enjin.sdk.events.EventFilter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the type of notification received.
 *
 * @author Evan Lindsay
 * @see NotificationEvent
 */
public enum EventType {

    UNKNOWN(null),
    APP_CREATED("EnjinCloud\\Events\\AppCreated", "app"),
    APP_DELETED("EnjinCloud\\Events\\AppDeleted", "app"),
    APP_LINKED("EnjinCloud\\Events\\AppLinked", "app", "wallet"),
    APP_LOCKED("EnjinCloud\\Events\\AppLocked", "app"),
    APP_UNLINKED("EnjinCloud\\Events\\AppUnlinked", "app", "wallet"),
    APP_UNLOCKED("EnjinCloud\\Events\\AppUnlocked", "app"),
    APP_UPDATED("EnjinCloud\\Events\\AppUpdated", "app"),
    BLOCKCHAIN_LOG_PROCESSED("EnjinCloud\\Events\\BlockchainLogProcessed", "app", "token", "wallet"),
    MESSAGE_PROCESSED("EnjinCloud\\Events\\MessageProcessed", "app", "token", "wallet"),
    PLAYER_CREATED("EnjinCloud\\Events\\IdentityCreated", "app", "player"),
    PLAYER_DELETED("EnjinCloud\\Events\\IdentityDeleted", "app", "player"),
    PLAYER_LINKED("EnjinCloud\\Events\\IdentityLinked", "app", "player", "wallet"),
    PLAYER_UNLINKED("EnjinCloud\\Events\\IdentityUnlinked", "app", "player", "wallet"),
    PLAYER_UPDATED("EnjinCloud\\Events\\IdentityUpdated", "app", "player"),
    TOKEN_CREATED("EnjinCloud\\Events\\TokenCreated", "app", "token", "wallet"),
    TOKEN_MELTED("EnjinCloud\\Events\\TokenMelted", "app", "token", "wallet"),
    TOKEN_MINTED("EnjinCloud\\Events\\TokenMinted", "app", "token", "wallet"),
    TOKEN_TRANSFERRED("EnjinCloud\\Events\\TokenTransferred", "app", "token", "wallet"),
    TOKEN_UPDATED("EnjinCloud\\Events\\TokenUpdated", "app", "token", "wallet"),
    TRADE_COMPLETED("EnjinCloud\\Events\\TradeCompleted", "app", "token", "wallet"),
    TRADE_CREATED("EnjinCloud\\Events\\TradeCreated", "app", "token", "wallet"),
    TRANSACTION_BROADCAST("EnjinCloud\\Events\\TransactionBroadcast", "app", "token", "wallet"),
    TRANSACTION_CANCELED("EnjinCloud\\Events\\TransactionCanceled", "app", "token", "wallet"),
    TRANSACTION_DROPPED("EnjinCloud\\Events\\TransactionDropped", "app", "token", "wallet"),
    TRANSACTION_EXECUTED("EnjinCloud\\Events\\TransactionExecuted", "app", "token", "wallet"),
    TRANSACTION_FAILED("EnjinCloud\\Events\\TransactionFailed", "app", "token", "wallet"),
    TRANSACTION_PENDING("EnjinCloud\\Events\\TransactionPending", "app", "token", "wallet"),
    TRANSACTION_PROCESSING("EnjinCloud\\Events\\TransactionProcessing", "app", "token", "wallet"),
    TRANSACTION_UPDATED("EnjinCloud\\Events\\TransactionUpdated", "app", "token", "wallet");

    /**
     * -- GETTER --
     * @return the event key
     */
    @Getter
    private final String key;

    /**
     * -- GETTER --
     * @return the channels
     */
    @Getter
    private final String[] channels;

    /**
     * Sole constructor.
     *
     * @param key the key of the event
     * @param channels the channels the event is broadcast on
     */
    EventType(String key, String... channels) {
        this.key = key;
        this.channels = channels;
    }

    /**
     * Checks if this type is a value in the given filter.
     *
     * @param filter the filter being processed
     * @return true if this type is in the filter, false otherwise
     */
    public boolean in(EventFilter filter) {
        if (filter != null)
            return this.in(filter.value());

        return false;
    }

    /**
     * Check if this type is present in the passed values.
     *
     * @param types the types to check
     * @return true if this type is present, false otherwise
     */
    public boolean in(EventType... types) {
        for (EventType type : types) {
            if (this == type)
                return true;
        }

        return false;
    }

    /**
     * Returns the event type for the given name.
     *
     * @param name the name of the type
     * @return the type if present, or {@link #UNKNOWN}
     */
    public static EventType getFromName(String name) {
        for (EventType type : EventType.values()) {
            if (type.name().equalsIgnoreCase(name))
                return type;
        }

        return UNKNOWN;
    }

    /**
     * Returns the event type for the given key.
     *
     * @param key the key of the type
     * @return the type if present, or {@link #UNKNOWN}
     */
    public static EventType getFromKey(String key) {
        for (EventType type : EventType.values()) {
            if (type.getKey().equalsIgnoreCase(key))
                return type;
        }

        return UNKNOWN;
    }

    /**
     * Returns a list of event types that broadcast on the specified channel.
     *
     * @param channel the channel to filter by
     * @return the list of types
     */
    public static List<EventType> filterByChannelTypes(String channel) {
        List<EventType> types = new ArrayList<>();

        for (EventType type : values()) {
            for (String key : type.channels) {
                if (channel.toLowerCase().contains(key)) {
                    types.add(type);
                    break;
                }
            }
        }

        return types;
    }
}
