package com.enjin.enjincoin.sdk.client.service.requests.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Update Request Response class.</p>
 */
public class UpdateRequestRequestBody {

    @SerializedName("value")
    private String value;

    @SerializedName("recipient_id")
    private Integer recipientId;


    /**
     * Class constructor.
     * @param value
     * @param recipientId
     */
    public UpdateRequestRequestBody(String value, Integer recipientId) {
        super();
        this.value = value;
        this.recipientId = recipientId;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @return the recipientId
     */
    public Integer getRecipientId() {
        return recipientId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CreateRequestRequestBody [value=" + value + ", recipientId=" + recipientId + "]";
    }
}

