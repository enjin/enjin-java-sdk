package io.enjincoin.sdk.client.service.identities.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Link Identity Request class.
 * </p>
 */
public class LinkIdentityRequestBody {

    @SerializedName("ethereum_address")
    private Optional<String> ethereumAddress;

    /**
     * Class constructor
     * @param ethereumAddress
     */
    public LinkIdentityRequestBody(Optional<String> ethereumAddress) {
        super();
        this.ethereumAddress = ethereumAddress;
    }

    /**
     * @return the ethereumAddress
     */
    public Optional<String> getEthereumAddress() {
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
