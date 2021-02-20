package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models Pusher channels used by the platform.
 */
@EqualsAndHashCode
@Getter
public class PusherChannels {

    /**
     * -- Getter --
     * @return the project channel
     */
    @SerializedName("project")
    private String project;

    /**
     * -- Getter --
     * @return the player channel
     */
    private String player;

    /**
     * -- Getter --
     * @return the asset channel
     */
    private String asset;

    /**
     * -- Getter --
     * @return the wallet channel
     */
    private String wallet;

}
