package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * Models a token balance.
 */
@Getter
public class Balance {

    /**
     * -- Getter --
     * @return the token (item) ID for this balance
     */
    private String id;

    /**
     * -- Getter --
     * @return the token (item) index for this balance
     */
    private String index;

    /**
     * -- Getter --
     * @return the balance for this token
     */
    private Integer value;

    /**
     * -- Getter --
     * @return the project for this balance's token
     */
    @SerializedName("app")
    private Project project;

    /**
     * -- Getter --
     * @return the wallet for this balance
     */
    private Wallet wallet;

}
