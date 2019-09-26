package com.enjin.enjincoin.sdk.model.service.platform;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

/**
 * Will contain information regarding the trusted platfrom, blockchain, and any
 * other configurations details that are to fully utilize the capabilities of
 * the trusted platform.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.platform.PlatformService
 * @see NotificationDetails
 */
@Getter
@ToString
public class PlatformDetails {

    /**
     * The name of the trusted platform.
     *
     * @return the trusted platform name.
     */
    private String name;

    /**
     * The trusted platform id.
     *
     * @return the trusted platform id.
     */
    private Integer id;

    /**
     * The blockchain network the trusted platform operates on.
     *
     * @return the trusted platform network.
     */
    private String network;

    /**
     * The network block height.
     *
     * @return the network block height.
     */
    @SerializedName("blockheight")
    private Integer blockHeight;

    /**
     * The notification details.
     *
     * @return the trusted platform notification details.
     */
    private NotificationDetails notifications;

}
