package io.enjincoin.sdk.client.service.requests.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create Request Response class.</p>
 */
public class ExecuteRequestRequestBody {


    @SerializedName("data")
    private Optional<String> data;


    /**
     * Class constructor.
     * @param data
     */
    public ExecuteRequestRequestBody(String data) {
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
        return "ExecuteRequestRequestBody [data=" + data + "]";
    }
}

