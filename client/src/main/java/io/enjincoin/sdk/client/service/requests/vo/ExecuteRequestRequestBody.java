package io.enjincoin.sdk.client.service.requests.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create Request Response class.</p>
 */
public class ExecuteRequestRequestBody {


    @SerializedName("data")
    private String data;


    /**
     * Class constructor.
     * @param data
     */
    public ExecuteRequestRequestBody(String data) {
        super();
        this.data = data;
    }

    /**
     * @return the data
     */
    public String getData() {
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

