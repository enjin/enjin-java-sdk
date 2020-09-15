package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * The fields of the {@link Request} type.
 *
 * @see TransactionSort
 */
public enum TransactionField {

    @SerializedName("id")
    ID,
    @SerializedName("state")
    STATE,
    @SerializedName("title")
    TITLE,
    @SerializedName("createdAt")
    CREATED_AT,

}
