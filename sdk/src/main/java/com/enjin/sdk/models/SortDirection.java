package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for sort direction in sorting inputs.
 */
public enum SortDirection {

    @SerializedName("asc")
    ASCENDING,
    @SerializedName("desc")
    DESCENDING,

}
