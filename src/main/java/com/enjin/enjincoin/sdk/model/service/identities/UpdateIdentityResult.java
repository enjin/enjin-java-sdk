package com.enjin.enjincoin.sdk.model.service.identities;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * The result of an update identity request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.identities.IdentitiesService
 */
@Getter
public class UpdateIdentityResult {

    /**
     * The updated identity.
     *
     * @return the updated identity.
     */
    @SerializedName("UpdateEnjinIdentity")
    private Identity identity;

}
