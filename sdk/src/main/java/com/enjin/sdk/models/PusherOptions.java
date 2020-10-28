package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models Pusher options used by the platform.
 */
@EqualsAndHashCode
@Getter
public class PusherOptions {

    /**
     * -- Getter --
     * @return the cluster
     */
    private String cluster;

    /**
     * -- Getter --
     * @return whether encryption is used or not
     */
    private Boolean encrypted;

}
