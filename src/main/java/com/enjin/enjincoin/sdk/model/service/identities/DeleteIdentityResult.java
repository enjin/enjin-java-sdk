package com.enjin.enjincoin.sdk.model.service.identities;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * The result of a delete identity request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.identities.IdentitiesService
 */
@Getter
public class DeleteIdentityResult {

    /**
     * The unlinked or deleted identity.
     *
     * @return the unlinked or deleted identity.
     */
    @SerializedName("DeleteEnjinIdentity")
    private Identity identity;

}
