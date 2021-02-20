package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Values used to specify the format to render an asset's ID in.
 */
public enum AssetIdFormat {

    @SerializedName("hex64")
    HEX64,
    @SerializedName("hex256")
    HEX256,
    @SerializedName("uint256")
    UINT256,

}
