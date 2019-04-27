package com.enjin.enjincoin.sdk.model.service.requests;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * The result of a create request request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.requests.RequestsService
 */
@Getter
public class CreateRequestResult {

    /**
     * The created request.
     *
     * @return the created request.
     */
    @SerializedName("CreateEnjinRequest")
    private Transaction request;

}
