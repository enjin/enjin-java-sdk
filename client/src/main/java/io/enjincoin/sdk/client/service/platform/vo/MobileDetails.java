package io.enjincoin.sdk.client.service.platform.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Mobile Details class
 * </p>
 */
public class MobileDetails {

    @SerializedName("type")
    private String type;

    /**
     * Class constructor.
     * @param type
     */
    public MobileDetails(String type) {
        super();
        this.type = type;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MobileDetails [type=" + type + "]";
    }
}
