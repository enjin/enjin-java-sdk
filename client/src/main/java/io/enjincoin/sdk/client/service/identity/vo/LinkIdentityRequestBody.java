package io.enjincoin.sdk.client.service.identity.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Link Identity Request class.
 * </p>
 */
public class LinkIdentityRequestBody {

    @SerializedName("ethereum_address")
    private String ethereumAddress;

    /**
     * Class constructor
     * @param ethereumAddress
     */
    public LinkIdentityRequestBody(String ethereumAddress) {
        super();
        this.ethereumAddress = ethereumAddress;
    }

    /**
     * @return the ethereumAddress
     */
    public String getEthereumAddress() {
        return ethereumAddress;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LinkIdentityRequestVO [ethereumAddress=" + ethereumAddress + "]";
    }


}
