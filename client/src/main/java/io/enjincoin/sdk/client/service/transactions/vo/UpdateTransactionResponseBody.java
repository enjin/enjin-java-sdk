package io.enjincoin.sdk.client.service.transactions.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Transaction Response class.</p>
 */
public class UpdateTransactionResponseBody {

    @SerializedName("id")
    private Optional<Integer> id;

    @SerializedName("transaction_id")
    private Optional<Integer> transactionId;

    @SerializedName("app_id")
    private Optional<Integer> appId;

    @SerializedName("type")
    private Optional<String> type;

    @SerializedName("value")
    private Optional<String> value;

    @SerializedName("accepted")
    private Optional<Integer> accepted;

    @SerializedName("updated_at")
    private Optional<String> updatedAt;

    @SerializedName("created_at")
    private Optional<String> createdAt;


    /**
     * Class constructor
     * @param id
     * @param transactionId
     * @param appId
     * @param type
     * @param value
     * @param accepted
     * @param updatedAt
     * @param createdAt
     */
    public UpdateTransactionResponseBody(Integer id, Integer transactionId, Integer appId, String type, String value,
            Integer accepted, String updatedAt, String createdAt) {
        super();
        this.id = Optional.of(id);
        this.transactionId = Optional.of(transactionId);
        this.appId = Optional.of(appId);
        this.type = Optional.of(type);
        this.value = Optional.of(value);
        this.accepted = Optional.of(accepted);
        this.updatedAt = Optional.of(updatedAt);
        this.createdAt = Optional.of(createdAt);
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
     * @return the value
     */
    public Optional<String> getValue() {
        return value;
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UpdateTransactionResponseBody [id=" + id + ", transactionId=" + transactionId + ", appId=" + appId + ", type=" + type + ", value=" + value + ", accepted=" + accepted
                + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
    }
}


