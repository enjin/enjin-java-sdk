package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;

public class ListEventsRequestVO {

    @SerializedName("auth")
    private String auth;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("after_event_id")
    private String afterEventId;

    @SerializedName("limit")
    private String limit;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAfterEventId() {
        return afterEventId;
    }

    public void setAfterEventId(String afterEventId) {
        this.afterEventId = afterEventId;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "ListEventsRequestVO [auth=" + auth + ", appId=" + appId + ", afterEventId=" + afterEventId + ", limit="
                + limit + "]";
    }


}
