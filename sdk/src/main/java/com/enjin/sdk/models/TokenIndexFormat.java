package com.enjin.sdk.models;

import com.enjin.sdk.schemas.shared.arguments.BalanceFragmentArguments;
import com.google.gson.annotations.SerializedName;

/**
 * TODO
 * @see BalanceFragmentArguments
 */
public enum TokenIndexFormat {

    @SerializedName("hex64")
    HEX64,
    @SerializedName("uint64")
    UINT64,

}
