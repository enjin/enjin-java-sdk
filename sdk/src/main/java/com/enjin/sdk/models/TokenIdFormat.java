package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Values used specify the format to render an item's ID in.
 */
public enum TokenIdFormat {

    @SerializedName("hex64")
    HEX64,
    @SerializedName("hex256")
    HEX256,
    @SerializedName("uint256")
    UINT256,

}
