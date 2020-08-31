package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Values used specify the format to render an item's index in.
 */
public enum TokenIndexFormat {

    @SerializedName("hex64")
    HEX64,
    @SerializedName("uint64")
    UINT64,

}
