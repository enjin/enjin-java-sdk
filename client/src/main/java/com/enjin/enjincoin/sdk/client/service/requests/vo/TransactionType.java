package com.enjin.enjincoin.sdk.client.service.requests.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Transaction Type class.</p>
 */
public class TransactionType {

    @SerializedName("value")
    private String value;

    /**
     * Class constructor.
     * @param value
     */
    public TransactionType(String value) {
        super();
        this.value = value;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TransactionType [value=" + value + "]";
    }


}
