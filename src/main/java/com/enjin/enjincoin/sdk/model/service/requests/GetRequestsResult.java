package com.enjin.enjincoin.sdk.model.service.requests;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

/**
 * The result of a get requests request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.requests.RequestsService
 */
@Getter
public class GetRequestsResult {

    /**
     * The requests that match the query parameters.
     *
     * @return a list of requests that match the query parameters.
     */
    @SerializedName("EnjinTransactions")
    private List<Transaction> requests;

}
