package com.enjin.sdk.models.request;

import com.enjin.sdk.services.request.RequestsService;

/**
 * A builder for updating a request on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
public class UpdateRequest extends BaseRequest<UpdateRequest> {

    public UpdateRequest() {
        super(false);
    }

    public UpdateRequest id(Integer id) {
        set("id", id);
        return this;
    }

    /**
     * Can be set to retry or cancel a transaction.
     *
     * @param rebroadcast the rebroadcast type.
     *
     * @return the builder.
     */
    public UpdateRequest rebroadcast(RebroadcastType rebroadcast) {
        set("rebroadcast", rebroadcast);
        return this;
    }

}
