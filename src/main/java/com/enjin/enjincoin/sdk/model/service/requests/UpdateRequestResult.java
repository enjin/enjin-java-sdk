package com.enjin.enjincoin.sdk.model.service.requests;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * The result of an update request request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.requests.RequestsService
 */
@Getter
public class UpdateRequestResult {

    /**
     * The updated request.
     *
     * @return the updated request.
     */
    @SerializedName("UpdateEnjinRequest")
    private Transaction request;

}
