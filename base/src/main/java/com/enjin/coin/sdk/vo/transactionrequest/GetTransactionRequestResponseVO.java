package com.enjin.coin.sdk.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class GetTransactionRequestResponseVO {

    @SerializedName("txr_id")
    private String txrId;

    @SerializedName("identity")
    private Map<String, Object> identityMap;

    @SerializedName("recipient")
    private Map<String, Object> recipientMap;

    @SerializedName("type")
    private String type;
    @SerializedName("icon")
    private String icon;
    @SerializedName("title")
    private String title;


    @SerializedName("value")
    private Map<String, Object> valueMap;


    public String getTxrId() {
        return txrId;
    }

    public Map<String, Object> getIdentityMap() {
        return identityMap;
    }

    public Map<String, Object> getRecipientMap() {
        return recipientMap;
    }

    public String getType() {
        return type;
    }

    public String getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public Map<String, Object> getValueMap() {
        return valueMap;
    }

    @Override
    public String toString() {
        return "GetTransactionRequestResponseVO [txrId=" + txrId + ", identityMap=" + identityMap + ", recipientMap="
                + recipientMap + ", type=" + type + ", icon=" + icon + ", title=" + title + ", valueMap=" + valueMap
                + "]";
    }
}
