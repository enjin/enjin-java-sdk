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
    PROJECT_CREATED("EnjinCloud\\Events\\ProjectCreated", "project"),
    PROJECT_DELETED("EnjinCloud\\Events\\ProjectDeleted", "project"),
    PROJECT_LINKED("EnjinCloud\\Events\\ProjectLinked", "project", "wallet"),
    PROJECT_LOCKED("EnjinCloud\\Events\\ProjectLocked", "project"),
    PROJECT_UNLINKED("EnjinCloud\\Events\\ProjectUnlinked", "project", "wallet"),
    PROJECT_UNLOCKED("EnjinCloud\\Events\\ProjectUnlocked", "project"),
    PROJECT_UPDATED("EnjinCloud\\Events\\ProjectUpdated", "project"),
    BLOCKCHAIN_LOG_PROCESSED("EnjinCloud\\Events\\BlockchainLogProcessed", "project", "asset", "wallet"),
    MESSAGE_PROCESSED("EnjinCloud\\Events\\MessageProcessed", "project", "asset", "wallet"),
    PLAYER_CREATED("EnjinCloud\\Events\\PlayerCreated", "project", "player"),
    PLAYER_DELETED("EnjinCloud\\Events\\PlayerDeleted", "project", "player"),
    PLAYER_LINKED("EnjinCloud\\Events\\PlayerLinked", "project", "player", "wallet"),
    PLAYER_UNLINKED("EnjinCloud\\Events\\PlayerUnlinked", "project", "player", "wallet"),
    PLAYER_UPDATED("EnjinCloud\\Events\\PlayerUpdated", "project", "player"),
    ASSET_CREATED("EnjinCloud\\Events\\AssetCreated", "project", "asset", "wallet"),
    ASSET_MELTED("EnjinCloud\\Events\\AssetMelted", "project", "asset", "wallet"),
    ASSET_MINTED("EnjinCloud\\Events\\AssetMinted", "project", "asset", "wallet"),
    ASSET_TRANSFERRED("EnjinCloud\\Events\\AssetTransferred", "project", "asset", "wallet"),
    ASSET_UPDATED("EnjinCloud\\Events\\AssetUpdated", "project", "asset", "wallet"),
    TRADE_ASSET_COMPLETED("EnjinCloud\\Events\\TradeAssetCompleted", "project", "asset", "wallet"),
    TRADE_ASSET_CREATED("EnjinCloud\\Events\\TradeAssetCreated", "project", "asset", "wallet"),
    TRANSACTION_BROADCAST("EnjinCloud\\Events\\TransactionBroadcast", "project", "asset", "wallet"),
    TRANSACTION_CANCELED("EnjinCloud\\Events\\TransactionCanceled", "project", "asset", "wallet"),
    TRANSACTION_DROPPED("EnjinCloud\\Events\\TransactionDropped", "project", "asset", "wallet"),
    TRANSACTION_EXECUTED("EnjinCloud\\Events\\TransactionExecuted", "project", "asset", "wallet"),
    TRANSACTION_FAILED("EnjinCloud\\Events\\TransactionFailed", "project", "asset", "wallet"),
    TRANSACTION_PENDING("EnjinCloud\\Events\\TransactionPending", "project", "asset", "wallet"),
    TRANSACTION_PROCESSING("EnjinCloud\\Events\\TransactionProcessing", "project", "asset", "wallet"),
    TRANSACTION_UPDATED("EnjinCloud\\Events\\TransactionUpdated", "project", "asset", "wallet");

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
