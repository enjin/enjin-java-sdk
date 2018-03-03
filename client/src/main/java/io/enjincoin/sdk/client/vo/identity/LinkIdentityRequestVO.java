package io.enjincoin.sdk.client.vo.identity;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Link Identity Request class.
 * </p>
 */
public class LinkIdentityRequestVO {

    @SerializedName("ethereum_address")
    private Optional<String> ethereumAddress;

    /**
     * Class constructor
     * @param ethereumAddress
     */
    public LinkIdentityRequestVO(Optional<String> ethereumAddress) {
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
