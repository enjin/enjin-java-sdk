package io.enjincoin.sdk.client.service.requests.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Update Request Response class.</p>
 */
public class UpdateRequestRequestBody {

    @SerializedName("value")
    private Optional<String> value;

    @SerializedName("recipient_id")
    private Optional<Integer> recipientId;


    /**
     * Class constructor.
     * @param value
     * @param recipientId
     */
    public UpdateRequestRequestBody(String value, Integer recipientId) {
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
        return "CreateRequestRequestBody [value=" + value + ", recipientId=" + recipientId + "]";
    }
}

