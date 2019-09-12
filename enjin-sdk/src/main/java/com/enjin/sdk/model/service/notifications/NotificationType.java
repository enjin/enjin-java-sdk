package com.enjin.sdk.model.service.notifications;

import com.enjin.sdk.service.notifications.EventFilter;

/**
 * Represent the type of notification received.
 *
 * @author Evan Lindsay
 * @see NotificationEvent
 */
public enum NotificationType {

    UNKNOWN_EVENT("unknown"),
    TXR_PENDING("txr_pending"),
    TXR_CANCELED_USER("txr_canceled_user"),
    TXR_CANCELED_PLATFORM("txr_canceled_platform"),
    TXR_ACCEPTED("txr_accepted"),
    TX_BROADCASTED("tx_broadcast"),
    TX_EXECUTED("tx_executed"),
    TX_CONFIRMED("tx_confirmed"),
    IDENTITY_CREATED("identity_created"),
    IDENTITY_LINKED("identity_linked"),
    IDENTITY_UPDATED("identity_updated"),
    IDENTITY_DELETED("identity_deleted"),
    BALANCE_UPDATED("balance_updated"),
    BALANCE_MELTED("balance_melted"),
    TOKEN_UPDATED("item_updated"),
    TOKEN_CREATED("item_created"),
    APP_CREATED("app_created"),
    APP_UPDATED("app_updated"),
    APP_DELETED("app_deleted");

    private final String eventType;

    NotificationType(String eventType) {
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
    public boolean in(NotificationType... types) {
        for (NotificationType type : types) {
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
    public static NotificationType valueOfEnum(String name) {
        NotificationType type;

        try {
            type = valueOf(name);
        } catch (IllegalArgumentException e) {
            type = UNKNOWN_EVENT;
        }

        return type;
    }
}
