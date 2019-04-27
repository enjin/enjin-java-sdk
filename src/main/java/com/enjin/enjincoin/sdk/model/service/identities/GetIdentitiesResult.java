package com.enjin.enjincoin.sdk.model.service.identities;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

/**
 * The result of a get identities request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.identities.IdentitiesService
 */
@Getter
public class GetIdentitiesResult {

    /**
     * The identities that match the query parameters.
     *
     * @return a list of identities that match the query parameters.
     */
    @SerializedName("EnjinIdentities")
    private List<Identity> identities;

}
