package com.enjin.enjincoin.sdk.client.service.requests.vo;

import com.google.gson.annotations.SerializedName;

import com.enjin.enjincoin.sdk.client.service.tokens.vo.Token;
import com.enjin.enjincoin.sdk.client.service.users.vo.UserResponseBody;

/**
 * <p>Request Response class.</p>
 */
public class RequestResponseBody {

    @SerializedName("id")
    private Integer id;

    @SerializedName("transaction_id")
    private Integer transactionId;

    @SerializedName("app_id")
    private Integer appId;

    @SerializedName("type")
    private String type;

    @SerializedName("icon")
    private String icon;

    @SerializedName("title")
    private String title;

    @SerializedName("value")
    private String value;

    @SerializedName("state")
    private String state;

    @SerializedName("accepted")
    private Integer accepted;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("identity")
    private UserResponseBody identity;

    @SerializedName("recipient")
    private UserResponseBody recipient;

    @SerializedName("token")
    private Token token;


    /**
     * Class constructor.
     * @param id
     * @param transactionId
     * @param appId
     * @param type
     * @param icon
     * @param title
     * @param value
     * @param state
     * @param accepted
     * @param updatedAt
     * @param createdAt
     * @param identity
     * @param recipient
     * @param token
     */
    public RequestResponseBody(Integer id, Integer transactionId, Integer appId, String type, String icon, String title,
            String value, String state, Integer accepted, String updatedAt, String createdAt, UserResponseBody identity,
            UserResponseBody recipient, Token token) {
        super();
        this.id = id;
        this.transactionId = transactionId;
        this.appId = appId;
        this.type = type;
        this.icon = icon;
        this.title = title;
        this.value = value;
        this.state = state;
        this.accepted = accepted;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.identity = identity;
        this.recipient = recipient;
        this.token = token;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * @return the transactionId
     */
    public Integer getTransactionId() {
        return this.transactionId;
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
    public String getType() {
        return this.type;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return this.icon;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @return the state
     */
    public String getState() {
        return this.state;
    }

    /**
     * @return the accepted
     */
    public Integer getAccepted() {
        return this.accepted;
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
        return "RequestResponseBody [id=" + this.id + ", transactionId=" + this.transactionId + ", appId=" + this.appId + ", type=" + this.type + ", icon=" + this.icon + ", title=" + this.title + ", value=" + this.value
                + ", state=" + this.state + ", accepted=" + this.accepted + ", updatedAt=" + this.updatedAt + ", createdAt=" + this.createdAt + ", identity=" + this.identity + ", recipient=" + this.recipient + ", token="
                + this.token + "]";
    }
}


