package com.enjin.coin.sdk.enums;

/**
 * <p> Notification types which can be received from the ThirdPartyNotificationService </p>
 *
 */
public enum NotificationTypeEnum {

    UNKNOWN_EVENT("unknown"),
    TXR_PENDING("txr_pending"),
    TXR_CANCELED_USER("txr_canceled_user"),
    TXR_CANCELED_PLATFORM("txr_canceled_platform"),
    TXR_ACCEPTED("txr_accepted"),
    TX_BROADCASTED("tx_broadcasted"),
    TX_EXECUTED("tx_executed"),
    TX_CONFIRMED("tx_confirmed"),
    IDENTITY_CREATED("identity_created"),
    IDENTITY_LINKED("identity_linked"),
    IDENTITY_UPDATED("identity_updated"),
    IDENTITY_DELETED("identity_deleted"),
    BALANCE_UPDATED("balance_updated"),
    BALANCE_MELTED("balance_melted"),
    TOKEN_UPDATED("token_updated"),
    TOKEN_CREATED("token_created");


    private String eventType;

    NotificationTypeEnum(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}
