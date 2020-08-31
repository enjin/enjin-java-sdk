package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * Models Pusher channels used by the platform.
 */
@Getter
public class PusherChannels {

    /**
     * -- Getter --
     * @return the app channel
     */
    @SerializedName("app")
    private String project;

    /**
     * -- Getter --
     * @return the player channel
     */
    private String player;

    /**
     * -- Getter --
     * @return the token channel
     */
    private String token;

    /**
     * -- Getter --
     * @return the wallet channel
     */
    private String wallet;

}
