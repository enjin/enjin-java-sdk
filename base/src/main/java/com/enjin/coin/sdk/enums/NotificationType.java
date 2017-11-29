package com.enjin.coin.sdk.enums;

/**
 * <p> Notification types which can be received from the ThirdPartyNotificationService.</p>
 *
 */
public enum NotificationType {

    /** Event - Unknown. **/
    UNKNOWN_EVENT("unknown"),
    /** Event - txr_pending. **/
    TXR_PENDING("txr_pending"),
    /** Event - txr_canceled_user. **/
    TXR_CANCELED_USER("txr_canceled_user"),
    /** Event - txr_canceled_platform. **/
    TXR_CANCELED_PLATFORM("txr_canceled_platform"),
    /** Event - txr_accepted. **/
    TXR_ACCEPTED("txr_accepted"),
    /** Event - tx_broadcasted. **/
    TX_BROADCASTED("tx_broadcasted"),
    /** Event - tx_executed. **/
    TX_EXECUTED("tx_executed"),
    /** Event - tx_confirmed. **/
    TX_CONFIRMED("tx_confirmed"),
    /** Event - identity_created. **/
    IDENTITY_CREATED("identity_created"),
    /** Event - identity_linked. **/
    IDENTITY_LINKED("identity_linked"),
    /** Event - identity_updated. **/
    IDENTITY_UPDATED("identity_updated"),
    /** Event - identity_deleted. **/
    IDENTITY_DELETED("identity_deleted"),
    /** Event - balance_updated. **/
    BALANCE_UPDATED("balance_updated"),
    /** Event - balance_melted. **/
    BALANCE_MELTED("balance_melted"),
    /** Event - token_updated. **/
    TOKEN_UPDATED("token_updated"),
    /** Event - token_created. **/
    TOKEN_CREATED("token_created");

    /** Local eventType variable. **/
    private String eventType;

    /**
     * Enum constructor.
     * @param eventType
     */
    NotificationType(final String eventType) {
        this.eventType = eventType;
    }

    /**
     * Method to get the eventType.
     * @return String
     */
    public String getEventType() {
        return eventType;
    }
}
