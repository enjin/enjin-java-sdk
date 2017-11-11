package com.enjin.coin.sdk.vo.token;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class ListTokensResponseVO {

    @SerializedName("getTokenResponseVOArray")
    private GetTokenResponseVO[] getTokensResponseVOArray;

    public GetTokenResponseVO[] getGetTokensResponseVOArray() {
        return getTokensResponseVOArray;
    }

    public void setGetTokensResponseVOArray(GetTokenResponseVO[] getTokensResponseVOArray) {
        this.getTokensResponseVOArray = getTokensResponseVOArray;
    }

    @Override
    public String toString() {
        return "ListTokensResponseVO [getTokensResponseVOArray=" + Arrays.toString(getTokensResponseVOArray) + "]";
    }


}
