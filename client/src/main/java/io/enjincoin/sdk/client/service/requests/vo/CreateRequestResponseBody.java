package io.enjincoin.sdk.client.service.requests.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

import io.enjincoin.sdk.client.service.tokens.vo.Token;
import io.enjincoin.sdk.client.service.users.vo.UserResponseBody;

/**
 * <p>Request Response class.</p>
 */
public class CreateRequestResponseBody {

    @SerializedName("app_id")
    private Optional<Integer> appId;

    @SerializedName("type")
    private Optional<TransactionType> type;

    @SerializedName("value")
    private Optional<String> value;

    @SerializedName("updated_at")
    private Optional<String> updatedAt;

    @SerializedName("created_at")
    private Optional<String> createdAt;

    @SerializedName("id")
    private Optional<Integer> id;

    @SerializedName("identity")
    private Optional<UserResponseBody> identity;

    @SerializedName("recipient")
    private Optional<UserResponseBody> recipient;

    @SerializedName("token")
    private Optional<Token> token;


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
        this.appId = Optional.of(appId);
        this.type = Optional.of(type);
        this.value = Optional.of(value);
        this.updatedAt = Optional.of(updatedAt);
        this.createdAt = Optional.of(createdAt);
        this.id = Optional.of(id);
        this.identity = Optional.of(identity);
        this.recipient = Optional.of(recipient);
        this.token = Optional.of(token);
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
    public Optional<TransactionType> getType() {
        return type;
    }

    /**
     * @return the value
     */
    public Optional<String> getValue() {
        return value;
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
     * @return the id
     */
    public Optional<Integer> getId() {
        return id;
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
        return "CreateRequestResponseBody [appId=" + appId + ", type=" + type + ", value=" + value + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + ", id=" + id
                + ", identity=" + identity + ", recipient=" + recipient + ", token=" + token + "]";
    }
}


