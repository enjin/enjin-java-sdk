package com.enjin.sdk.model.service.platform;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

/**
 * Will contain details regarding the sdk notification type and settings.
 *
 * @author Evan Lindsay
 * @see NotificationDetails
 * @see SdkOptions
 */
@ToString
@Getter
public class SdkDetails {

    /**
     * The notification driver to use.
     *
     * @return the driver to use.
     */
    private String driver;

    /**
     * The auth key.
     *
     * @return the auth key.
     */
    private String key;

    /**
     * The auth secret.
     *
     * @return the auth secret.
     */
    private String secret;

    /**
     * The notification service app id (not to be confused with trusted platform apps).
     *
     * @return the app id.
     */
    @SerializedName("app_id")
    private String appId;

    /**
     * The sdk notification options.
     *
     * @return the sdk notification options.
     */
    private SdkOptions options;

}
