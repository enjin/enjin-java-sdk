package io.enjincoin.sdk.client.service.requests.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create Request Response class.</p>
 */
public class CreateRequestRequestBody {

    @SerializedName("identity_id")
    private Integer identityId;

    @SerializedName("token_id")
    private Integer tokenId;

    @SerializedName("app_id")
    private Integer appId;

    @SerializedName("value")
    private String value;

    @SerializedName("recipient_id")
    private Integer recipientId;


    /**
     * Class constructor.
     * @param identityId
     * @param tokenId
     * @param appId
     * @param value
     * @param recipientId
     */
    public CreateRequestRequestBody(Integer identityId, Integer tokenId, Integer appId, String value, Integer recipientId) {
        super();
        this.identityId = identityId;
        this.tokenId = tokenId;
        this.appId = appId;
        this.value = value;
        this.recipientId = recipientId;
    }

    /**
     * @return the identityId
     */
    public Integer getIdentityId() {
        return identityId;
    }

    /**
     * @return the tokenId
     */
    public Integer getTokenId() {
        return tokenId;
    }

    /**
     * @return the appId
     */
    public Integer getAppId() {
        return appId;
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
        return "CreateRequestRequestBody [identityId=" + identityId + ", tokenId=" + tokenId + ", appId=" + appId + ", value=" + value + ", recipientId=" + recipientId + "]";
    }
}

