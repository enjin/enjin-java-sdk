package io.enjincoin.sdk.client.vo.identity;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>FieldVO class.
 * </p>
 */
public class FieldVO {

    @SerializedName("key")
    private Optional<String> key;

    @SerializedName("field_value")
    private Optional<String> fieldValue;

    @SerializedName("searchable")
    private Optional<Integer> searchable;

    @SerializedName("displayable")
    private Optional<Integer> displayable;

    @SerializedName("unique")
    private Optional<Integer> unique;


    /**
     * Class constructor.
     * @param key
     * @param fieldValue
     * @param searchable
     * @param displayable
     * @param unique
     */
    public FieldVO(Optional<String> key, Optional<String> fieldValue, Optional<Integer> searchable, Optional<Integer> displayable, Optional<Integer> unique) {
        super();
        this.key = key;
        this.fieldValue = fieldValue;
        this.searchable = searchable;
        this.displayable = displayable;
        this.unique = unique;
    }

    /**
     * @return the key
     */
    public Optional<String> getKey() {
        return key;
    }

    /**
     * @return the fieldValue
     */
    public Optional<String> getFieldValue() {
        return fieldValue;
    }

    /**
     * @return the searchable
     */
    public Optional<Integer> getSearchable() {
        return searchable;
    }

    /**
     * @return the displayable
     */
    public Optional<Integer> getDisplayable() {
        return displayable;
    }

    /**
     * @return the unique
     */
    public Optional<Integer> getUnique() {
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
