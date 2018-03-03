package io.enjincoin.sdk.client.vo.identity;

import java.util.Optional;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.google.gson.annotations.SerializedName;

import io.enjincoin.sdk.client.annotations.immutables.SkipNulls;

/**
 * <p>Get Identity Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters(emptyAsNulls = true)
public abstract class GetIdentityResponseVO {


    /**
     * Method to get the identityId.
     *
     * @return Optional
     */
    @SerializedName("id")
    public abstract Optional<Integer> getId();

    /**
     * Method to get the ethereumAddress.
     *
     * @return Optional
     */
    @SerializedName("ethereum_address")
    public abstract Optional<String> getEthereumAddress();

    /**
     * Method to get the linkingCode.
     *
     * @return Optional
     */
    @SerializedName("linking_code")
    public abstract Optional<String> getLinking_code();

    /**
     * Method to get the updatedAt.
     *
     * @return Optional
     */
    @SerializedName("updated_at")
    public abstract Optional<String> getUpdated_at();

    /**
     * Method to get the createdAt.
     *
     * @return Optional
     */
    @SerializedName("created_at")
    public abstract String getCreated_at();

    /**
     * Method to get the user.
     *
     * @return Optional
     */
    @SerializedName("user")
    public abstract Optional<String> getUser();


    /**
     * Method to get the fields.
     *
     * @return Optional
     */
    @SkipNulls
    @SerializedName("fields")
    public abstract Optional<ImmutableFieldVO[]> getFields();

    @Override
    public String toString() {
        return "GetIdentityResponseVO [getId()=" + getId() + ", getEthereum_address()=" + getEthereumAddress() + ", getLinking_code()=" + getLinking_code() + ", getUpdated_at()="
                + getUpdated_at() + ", getCreated_at()=" + getCreated_at() + ", getUser()=" + getUser() + ", getFields()=" + getFields() + "]";
    }



}
