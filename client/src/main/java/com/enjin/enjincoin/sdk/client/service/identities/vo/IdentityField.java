package com.enjin.enjincoin.sdk.client.service.identities.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>FieldVO class.
 * </p>
 */
public class IdentityField {

    @SerializedName("key")
    private String key;

    @SerializedName("field_value")
    private String fieldValue;

    @SerializedName("searchable")
    private Integer searchable;

    @SerializedName("displayable")
    private Integer displayable;

    @SerializedName("unique")
    private Integer unique;

    public IdentityField(final String key, final String fieldValue, final Integer searchable, final Integer displayable, final Integer unique) {
        super();
        this.key = key;
        this.fieldValue = fieldValue;
        this.searchable = searchable;
        this.displayable = displayable;
        this.unique = unique;
    }

    public IdentityField(final String key, final String value) {
        this.key = key;
        this.fieldValue = value;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * @return the fieldValue
     */
    public String getFieldValue() {
        return this.fieldValue;
    }

    /**
     * @return the searchable
     */
    public Integer getSearchable() {
        return this.searchable;
    }

    /**
     * @return the displayable
     */
    public Integer getDisplayable() {
        return this.displayable;
    }

    /**
     * @return the unique
     */
    public Integer getUnique() {
        return this.unique;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FieldVO [key=" + this.key
                + ", fieldValue=" + this.fieldValue
                + ", searchable=" + this.searchable
                + ", displayable=" + this.displayable
                + ", unique=" + this.unique + "]";
    }
}
