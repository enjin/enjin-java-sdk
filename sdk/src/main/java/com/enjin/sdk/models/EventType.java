package com.enjin.sdk.models;

import com.enjin.sdk.events.EventFilter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the type of notification received.
 *
 * @see NotificationEvent
 */
public enum EventType {

    /**
     * Value used by the SDK to indicate an unknown event type.
     */
    UNKNOWN(null),
    APP_CREATED("EnjinCloud\\Events\\AppCreated", "app"),
    APP_DELETED("EnjinCloud\\Events\\AppDeleted", "app"),
    APP_LINKED("EnjinCloud\\Events\\AppLinked", "app", "wallet"),
    APP_LOCKED("EnjinCloud\\Events\\AppLocked", "app"),
    APP_UNLINKED("EnjinCloud\\Events\\AppUnlinked", "app", "wallet"),
    APP_UNLOCKED("EnjinCloud\\Events\\AppUnlocked", "app"),
    APP_UPDATED("EnjinCloud\\Events\\AppUpdated", "app"),
    BLOCKCHAIN_LOG_PROCESSED("EnjinCloud\\Events\\BlockchainLogProcessed", "app", "asset", "wallet"),
    MESSAGE_PROCESSED("EnjinCloud\\Events\\MessageProcessed", "app", "asset", "wallet"),
    PLAYER_CREATED("EnjinCloud\\Events\\IdentityCreated", "app", "player"),
    PLAYER_DELETED("EnjinCloud\\Events\\IdentityDeleted", "app", "player"),
    PLAYER_LINKED("EnjinCloud\\Events\\IdentityLinked", "app", "player", "wallet"),
    PLAYER_UNLINKED("EnjinCloud\\Events\\IdentityUnlinked", "app", "player", "wallet"),
    PLAYER_UPDATED("EnjinCloud\\Events\\IdentityUpdated", "app", "player"),
    ASSET_CREATED("EnjinCloud\\Events\\AssetCreated", "app", "asset", "wallet"),
    ASSET_MELTED("EnjinCloud\\Events\\AssetMelted", "app", "asset", "wallet"),
    ASSET_MINTED("EnjinCloud\\Events\\AssetMinted", "app", "asset", "wallet"),
    ASSET_TRANSFERRED("EnjinCloud\\Events\\AssetTransferred", "app", "asset", "wallet"),
    ASSET_UPDATED("EnjinCloud\\Events\\AssetUpdated", "app", "asset", "wallet"),
    TRADE_COMPLETED("EnjinCloud\\Events\\TradeCompleted", "app", "asset", "wallet"),
    TRADE_CREATED("EnjinCloud\\Events\\TradeCreated", "app", "asset", "wallet"),
    TRANSACTION_BROADCAST("EnjinCloud\\Events\\TransactionBroadcast", "app", "asset", "wallet"),
    TRANSACTION_CANCELED("EnjinCloud\\Events\\TransactionCanceled", "app", "asset", "wallet"),
    TRANSACTION_DROPPED("EnjinCloud\\Events\\TransactionDropped", "app", "asset", "wallet"),
    TRANSACTION_EXECUTED("EnjinCloud\\Events\\TransactionExecuted", "app", "asset", "wallet"),
    TRANSACTION_FAILED("EnjinCloud\\Events\\TransactionFailed", "app", "asset", "wallet"),
    TRANSACTION_PENDING("EnjinCloud\\Events\\TransactionPending", "app", "asset", "wallet"),
    TRANSACTION_PROCESSING("EnjinCloud\\Events\\TransactionProcessing", "app", "asset", "wallet"),
    TRANSACTION_UPDATED("EnjinCloud\\Events\\TransactionUpdated", "app", "asset", "wallet");

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
            if (key.equalsIgnoreCase(type.getKey()))
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
