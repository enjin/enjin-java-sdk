package com.enjin.coin.sdk.vo.token;

import com.google.gson.annotations.SerializedName;

public class ListTokensRequestVO {

    @SerializedName("app_id")
    private String appId;

    @SerializedName("after_token_id")
    private String afterTokenId;

    @SerializedName("limit")
    private String limit;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAfterTokenId() {
        return afterTokenId;
    }

    public void setAfterTokenId(String afterTokenId) {
        this.afterTokenId = afterTokenId;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "ListTokensRequestVO [appId=" + appId + ", afterTokenId=" + afterTokenId + ", limit=" + limit + "]";
    }

}
