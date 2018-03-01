package io.enjincoin.sdk.client.vo.identity;

import java.util.Optional;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.google.gson.annotations.SerializedName;

/**
 * <p>FieldVO class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class FieldVO {

    /**
     * Method to get the key.
     *
     * @return Optional
     */
    @SerializedName("key")
    public abstract Optional<String> getKey();

    /**
     * Method to get the fieldValue.
     *
     * @return Optional
     */
    @SerializedName("field_value")
    public abstract Optional<String> getField_value();

    /**
     * Method to get the searchable.
     *
     * @return Optional
     */
    @SerializedName("searchable")
    public abstract Optional<Integer> getSearchable();

    /**
     * Method to get the displayable.
     *
     * @return Optional
     */
    @SerializedName("displayable")
    public abstract Optional<Integer> getDisplayable();

    /**
     * Method to get the unique.
     *
     * @return Optional
     */
    @SerializedName("unique")
    public abstract Optional<Integer> getUnique();

    /**
     * Class toString method.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "FieldVO [getKey()=" + getKey() + ", getFieldValue()=" + getField_value() + ", getSearchable()=" + getSearchable() + ", getDisplayable()=" + getDisplayable() + ", getUnique()="
                + getUnique() + "]";
    }


}
