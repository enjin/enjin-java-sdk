package com.enjin.enjincoin.sdk.client.service.requests.vo;

import com.google.gson.annotations.SerializedName;

import com.enjin.enjincoin.sdk.client.service.tokens.vo.Token;
import com.enjin.enjincoin.sdk.client.service.users.vo.UserResponseBody;

/**
 * <p>Request Response class.</p>
 */
public class CreateRequestResponseBody {

    @SerializedName("app_id")
    private Integer appId;

    @SerializedName("type")
    private TransactionType type;

    @SerializedName("value")
    private String value;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private Integer id;

    @SerializedName("identity")
    private UserResponseBody identity;

    @SerializedName("recipient")
    private UserResponseBody recipient;

    @SerializedName("token")
    private Token token;


    /**
     * Class constructor.
     * @param appId
     * @param type
     * @param value
     * @param updatedAt
     * @param createdAt
     * @param id
     * @param identity
     * @param recipient
     * @param token
     */
    public CreateRequestResponseBody(Integer appId, TransactionType type, String value, String updatedAt, String createdAt,
            Integer id, UserResponseBody identity, UserResponseBody recipient, Token token) {
        super();
        this.appId = appId;
        this.type = type;
        this.value = value;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.id = id;
        this.identity = identity;
        this.recipient = recipient;
        this.token = token;
    }

    /**
     * @return the appId
     */
    public Integer getAppId() {
        return this.appId;
    }

    /**
     * @return the type
     */
    public TransactionType getType() {
        return this.type;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @return the updatedAt
     */
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * @return the identity
     */
    public UserResponseBody getIdentity() {
        return this.identity;
    }

    /**
     * @return the recipient
     */
    public UserResponseBody getRecipient() {
        return this.recipient;
    }

    /**
     * @return the token
     */
    public Token getToken() {
        return this.token;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CreateRequestResponseBody [appId=" + this.appId + ", type=" + this.type + ", value=" + this.value + ", updatedAt=" + this.updatedAt + ", createdAt=" + this.createdAt + ", id=" + this.id
                + ", identity=" + this.identity + ", recipient=" + this.recipient + ", token=" + this.token + "]";
    }
}


