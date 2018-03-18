package io.enjincoin.sdk.client.service.identity.vo;

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
    public long getTokenId() {
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
                "tokenId=" + tokenId +
                ", value=" + value +
                '}';
    }
}
