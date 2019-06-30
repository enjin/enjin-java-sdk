package com.enjin.enjincoin.sdk.model.service.requests;

import com.enjin.enjincoin.sdk.model.service.PaginationRequest;

/**
 * A builder for requests from the Trusted platform.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.requests.RequestsService
 */
public class DeleteRequest extends PaginationRequest<DeleteRequest> {

    /**
     * The request id.
     *
     * @param id the request id.
     *
     * @return the builder.
     */
    public DeleteRequest id(int id) {
        withParameter("id", id);
        return this;
    }

}
