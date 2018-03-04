package io.enjincoin.sdk.client.vo.identity;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;
import io.enjincoin.sdk.client.service.identities.vo.IdentityField;

/**
 * <p>Update Identity Request class.
 * </p>
 */
public class UpdateIdentityRequestVO {

    @SerializedName("fields")
    private Optional<IdentityField[]> fields;

    /**
     * Class constructor
     * @param fields
     */
    public UpdateIdentityRequestVO(Optional<IdentityField[]> fields) {
        super();
        this.fields = fields;
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
        return "UpdateIdentityRequestVO [fields=" + fields + "]";
    }


}
