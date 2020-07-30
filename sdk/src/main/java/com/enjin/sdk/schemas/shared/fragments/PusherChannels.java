package com.enjin.sdk.schemas.shared.fragments;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * TODO
 */
@Getter
public class PusherChannels {

    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    @SerializedName("app")
    private String project;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String player;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String token;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String wallet;

}
