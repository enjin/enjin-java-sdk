package io.enjincoin.sdk.client.service.requests.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Transaction Type class.</p>
 */
public class TransactionType {

    @SerializedName("value")
    private Optional<String> value;

    /**
     * Class constructor.
     * @param value
     */
    public TransactionType(String value) {
        super();
        this.value = Optional.of(value);
    }

    /**
     * @return the value
     */
    public Optional<String> getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Optional<String> value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TransactionType [value=" + value + "]";
    }


}
