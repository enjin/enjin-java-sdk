package com.enjin.sdk.models.request;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.request.RequestsService;

/**
 * A builder for requests from the Trusted platform.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
public class DeleteRequest extends PaginationRequest<DeleteRequest> implements TransactionFragment<DeleteRequest> {

    /**
     * The request id.
     *
     * @param id the request id.
     *
     * @return the builder.
     */
    public DeleteRequest id(int id) {
        set("id", id);
        return this;
    }

}
