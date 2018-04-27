package com.enjin.enjincoin.sdk.client.service.identities.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Update Identity Request class.
 * </p>
 */
public class UpdateIdentityRequestBody {

    @SerializedName("fields")
    private IdentityField[] fields;

    /**
     * Class constructor
     * @param fields
     */
    public UpdateIdentityRequestBody(IdentityField[] fields) {
        super();
        this.fields = fields;
    }

    /**
     * @return the fields
     */
    public IdentityField[] getFields() {
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
