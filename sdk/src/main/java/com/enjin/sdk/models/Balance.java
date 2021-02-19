package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models a asset balance.
 */
@EqualsAndHashCode
@Getter
public class Balance {

    /**
     * -- Getter --
     * @return the asset ID for this balance
     */
    private String id;

    /**
     * -- Getter --
     * @return the asset index for this balance
     */
    private String index;

    /**
     * -- Getter --
     * @return the amount of the asset
     */
    private Integer value;

    /**
     * -- Getter --
     * @return the project for this balance's asset
     */
    @SerializedName("app")
    private Project project;

    /**
     * -- Getter --
     * @return the wallet for this balance
     */
    private Wallet wallet;

}
