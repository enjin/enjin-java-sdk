package io.enjincoin.sdk.client.vo.legacy.identity;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * <p>Delete Identity Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class DeleteIdentityResponseVO {

    /**
     * Method to get the result.
     *
     * @return Optional
     */
    public abstract Optional<Boolean> getResult();

    /**
     * Class toString method.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "DeleteIdentityResponseVO [result=" + this.getResult().orElse(null) + "]";
    }

}
