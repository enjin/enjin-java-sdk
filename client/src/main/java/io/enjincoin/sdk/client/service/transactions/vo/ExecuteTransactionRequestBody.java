package io.enjincoin.sdk.client.service.transactions.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create Transaction Response class.</p>
 */
public class ExecuteTransactionRequestBody {


    @SerializedName("data")
    private Optional<String> data;


    /**
     * Class constructor.
     * @param data
     */
    public ExecuteTransactionRequestBody(String data) {
        super();
        this.data = Optional.of(data);
    }

    /**
     * @return the data
     */
    public Optional<String> getData() {
        return data;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ExecuteTransactionRequestBody [data=" + data + "]";
    }
}

