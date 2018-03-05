package io.enjincoin.sdk.client.service.transactions.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Update Transaction Response class.</p>
 */
public class UpdateTransactionRequestBody {

    @SerializedName("value")
    private Optional<String> value;

    @SerializedName("recipient_id")
    private Optional<Integer> recipientId;


    /**
     * Class constructor.
     * @param value
     * @param recipientId
     */
    public UpdateTransactionRequestBody(String value, Integer recipientId) {
        super();
        this.value = Optional.of(value);
        this.recipientId = Optional.of(recipientId);
    }

    /**
     * @return the value
     */
    public Optional<String> getValue() {
        return value;
    }

    /**
     * @return the recipientId
     */
    public Optional<Integer> getRecipientId() {
        return recipientId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CreateTransactionRequestBody [value=" + value + ", recipientId=" + recipientId + "]";
    }
}

