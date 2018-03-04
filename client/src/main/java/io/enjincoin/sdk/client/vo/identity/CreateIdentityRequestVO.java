package io.enjincoin.sdk.client.vo.identity;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;
import io.enjincoin.sdk.client.service.identities.vo.IdentityField;

/**
 * <p>Create Identity Request class.
 * </p>
 */
public class CreateIdentityRequestVO {

    @SerializedName("ethereum_address")
    private Optional<String> ethereumAddress;

    @SerializedName("fields")
    private Optional<IdentityField[]> fields;

    /**
     * Class constructor
     * @param ethereumAddress
     * @param fields
     */
    public CreateIdentityRequestVO(Optional<String> ethereumAddress, Optional<IdentityField[]> fields) {
        super();
        this.ethereumAddress = ethereumAddress;
        this.fields = fields;
    }

    /**
     * @return the ethereumAddress
     */
    public Optional<String> getEthereumAddress() {
        return ethereumAddress;
    }

    /**
     * @return the fields
     */
    public Optional<IdentityField[]> getFields() {
        return fields;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CreateIdentityRequestVO [ethereumAddress=" + ethereumAddress + ", fields=" + fields + "]";
    }


}
