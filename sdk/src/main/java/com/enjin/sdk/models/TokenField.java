package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * TODO
 */
public enum TokenField {

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
