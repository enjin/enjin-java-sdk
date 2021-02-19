package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Values used to specify the format to render an asset's index in.
 */
public enum AssetIndexFormat {

    @SerializedName("hex64")
    HEX64,
    @SerializedName("uint64")
    UINT64,

}
