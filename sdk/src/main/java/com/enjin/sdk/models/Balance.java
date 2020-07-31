package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * TODO
 */
@Getter
public class Balance {

    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String id;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String index;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Integer value;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    @SerializedName("app")
    private Project project;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Wallet wallet;

}
