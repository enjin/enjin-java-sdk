package io.enjincoin.sdk.client.service.requests.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

import io.enjincoin.sdk.client.service.tokens.vo.Token;
import io.enjincoin.sdk.client.service.users.vo.UserResponseBody;

/**
 * <p>Request Response class.</p>
 */
public class RequestResponseBody {

    @SerializedName("id")
    private Optional<Integer> id;

    @SerializedName("transaction_id")
    private Optional<Integer> transactionId;

    @SerializedName("app_id")
    private Optional<Integer> appId;

    @SerializedName("type")
    private Optional<String> type;

    @SerializedName("icon")
    private Optional<String> icon;

    @SerializedName("title")
    private Optional<String> title;

    @SerializedName("value")
    private Optional<String> value;

    @SerializedName("state")
    private Optional<String> state;

    @SerializedName("accepted")
    private Optional<Integer> accepted;

    @SerializedName("updated_at")
    private Optional<String> updatedAt;

    @SerializedName("created_at")
    private Optional<String> createdAt;

    @SerializedName("identity")
    private Optional<UserResponseBody> identity;

    @SerializedName("recipient")
    private Optional<UserResponseBody> recipient;

    @SerializedName("token")
    private Optional<Token> token;


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
        this.id = Optional.of(id);
        this.transactionId = Optional.of(transactionId);
        this.appId = Optional.of(appId);
        this.type = Optional.of(type);
        this.icon = Optional.of(icon);
        this.title = Optional.of(title);
        this.value = Optional.of(value);
        this.state = Optional.of(state);
        this.accepted = Optional.of(accepted);
        this.updatedAt = Optional.of(updatedAt);
        this.createdAt = Optional.of(createdAt);
        this.identity = Optional.of(identity);
        this.recipient = Optional.of(recipient);
        this.token = Optional.of(token);
    }

    /**
     * @return the id
     */
    public Optional<Integer> getId() {
        return id;
    }

    /**
     * @return the transactionId
     */
    public Optional<Integer> getTransactionId() {
        return transactionId;
    }

    /**
     * @return the appId
     */
    public Optional<Integer> getAppId() {
        return appId;
    }

    /**
     * @return the type
     */
    public Optional<String> getType() {
        return type;
    }

    /**
     * @return the icon
     */
    public Optional<String> getIcon() {
        return icon;
    }

    /**
     * @return the title
     */
    public Optional<String> getTitle() {
        return title;
    }

    /**
     * @return the value
     */
    public Optional<String> getValue() {
        return value;
    }

    /**
     * @return the state
     */
    public Optional<String> getState() {
        return state;
    }

    /**
     * @return the accepted
     */
    public Optional<Integer> getAccepted() {
        return accepted;
    }

    /**
     * @return the updatedAt
     */
    public Optional<String> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return the createdAt
     */
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the identity
     */
    public Optional<UserResponseBody> getIdentity() {
        return identity;
    }

    /**
     * @return the recipient
     */
    public Optional<UserResponseBody> getRecipient() {
        return recipient;
    }

    /**
     * @return the token
     */
    public Optional<Token> getToken() {
        return token;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RequestResponseBody [id=" + id + ", transactionId=" + transactionId + ", appId=" + appId + ", type=" + type + ", icon=" + icon + ", title=" + title + ", value=" + value
                + ", state=" + state + ", accepted=" + accepted + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + ", identity=" + identity + ", recipient=" + recipient + ", token="
                + token + "]";
    }
}


