package com.enjin.enjincoin.sdk.model.service.identities;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * The result of a create identity request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.identities.IdentitiesService
 */
@Getter
public class CreateIdentityResult {

    /**
     * The created identity.
     *
     * @return the created identity.
     */
    @SerializedName("CreateEnjinIdentity")
    private Identity identity;

}
