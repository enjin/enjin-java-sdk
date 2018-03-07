package io.enjincoin.sdk.client.service.identities.vo;

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


    /**
     * Class constructor.
     *
     * @param key
     * @param fieldValue
     * @param searchable
     * @param displayable
     * @param unique
     */
    public IdentityField(String key, String fieldValue, Integer searchable, Integer displayable, Integer unique) {
        super();
        this.key = key;
        this.fieldValue = fieldValue;
        this.searchable = searchable;
        this.displayable = displayable;
        this.unique = unique;
    }

    public IdentityField(String key, String value) {
        this.key = key;
        this.fieldValue = value;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return the fieldValue
     */
    public String getFieldValue() {
        return fieldValue;
    }

    /**
     * @return the searchable
     */
    public Integer getSearchable() {
        return searchable;
    }

    /**
     * @return the displayable
     */
    public Integer getDisplayable() {
        return displayable;
    }

    /**
     * @return the unique
     */
    public Integer getUnique() {
        return unique;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FieldVO [key=" + key + ", fieldValue=" + fieldValue + ", searchable=" + searchable + ", displayable=" + displayable + ", unique=" + unique + "]";
    }
}
