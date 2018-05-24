package com.enjin.enjincoin.sdk.client.service.identities.vo;

import com.google.gson.annotations.SerializedName;

public class TokenEntry {

    @SerializedName("token_id")
    private int tokenId;

    @SerializedName("value")
    private double value;

    /**
     * Class constructor.
     *
     * @param tokenId
     * @param value
     */
    public TokenEntry(int tokenId, double value) {
        this.tokenId = tokenId;
        this.value = value;
    }

    /**
     * @return the token id
     */
    public int getTokenId() {
        return this.tokenId;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "TokenEntry{" +
                "tokenId=" + this.tokenId +
                ", value=" + this.value +
                '}';
    }

    public void setValue(double value) {
        this.value = value;
        if (this.value < 0)
            this.value = 0;
    }
}
