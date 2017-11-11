package com.enjin.coin.sdk.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class ListTransactionRequestsRequestVO {

    @SerializedName("auth")
    private String auth;

    @SerializedName("identity")
    private Map<String, Object> identityMap;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("recipient")
    private Map<String, Object> recipientMap;

    @SerializedName("type")
    private String type;

    @SerializedName("after_txr_id")
    private String afterTxrId;

    @SerializedName("limit")
    private String limit;

    @SerializedName("currency")
    private String currency;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public Map<String, Object> getIdentityMap() {
        return identityMap;
    }

    public void setIdentityMap(Map<String, Object> identityMap) {
        this.identityMap = identityMap;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Map<String, Object> getRecipientMap() {
        return recipientMap;
    }

    public void setRecipientMap(Map<String, Object> recipientMap) {
        this.recipientMap = recipientMap;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAfterTxrId() {
        return afterTxrId;
    }

    public void setAfterTxrId(String afterTxrId) {
        this.afterTxrId = afterTxrId;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
