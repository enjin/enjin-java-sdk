package com.enjin.sdk.model.service.requests;

import com.enjin.sdk.model.service.PaginationRequest;
import com.enjin.sdk.service.requests.RequestsService;

/**
 * A builder for requests from the Trusted platform.
 *
 * @author Evan Lindsay
 * @see RequestsService
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
