package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * The fields of the {@link Asset} type.
 *
 * @see AssetSort
 */
public enum AssetField {

    @SerializedName("id")
    ID,
    @SerializedName("name")
    NAME,
    @SerializedName("circulatingSupply")
    CIRCULATING_SUPPLY,
    @SerializedName("nonFungible")
    NON_FUNGIBLE,
    @SerializedName("reserve")
    RESERVE,
    @SerializedName("totalSupply")
    TOTAL_SUPPLY,
    @SerializedName("createdAt")
    CREATED_AT,

}
