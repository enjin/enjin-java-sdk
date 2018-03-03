package io.enjincoin.sdk.client.vo.identity;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Update Identity Request class.
 * </p>
 */
public class UpdateIdentityRequestVO {

    @SerializedName("fields")
    private Optional<FieldVO[]> fields;

    /**
     * Class constructor
     * @param fields
     */
    public UpdateIdentityRequestVO(Optional<FieldVO[]> fields) {
        super();
        this.fields = fields;
    }

    /**
     * @return the fields
     */
    public Optional<FieldVO[]> getFields() {
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
