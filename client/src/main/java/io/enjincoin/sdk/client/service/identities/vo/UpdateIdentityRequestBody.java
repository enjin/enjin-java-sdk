package io.enjincoin.sdk.client.service.identities.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;
import io.enjincoin.sdk.client.service.identities.vo.IdentityField;

/**
 * <p>Update Identity Request class.
 * </p>
 */
public class UpdateIdentityRequestBody {

    @SerializedName("fields")
    private Optional<IdentityField[]> fields;

    /**
     * Class constructor
     * @param fields
     */
    public UpdateIdentityRequestBody(Optional<IdentityField[]> fields) {
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
