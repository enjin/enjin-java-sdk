package com.enjin.sdk.models.request;

import com.enjin.sdk.services.request.RequestsService;

/**
 * An object class for updating a request on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
public class UpdateRequest extends BaseRequest<UpdateRequest> {

    /**
     * Sole constructor.
     */
    public UpdateRequest() {
        super(false);
    }

    /**
     * The id of the transaction request.
     *
     * @param id the id.
     * @return   this request.
     */
    public UpdateRequest id(Integer id) {
        set("id", id);
        return this;
    }

    /**
     * Can be set to retry or cancel a transaction.
     *
     * @param rebroadcast the rebroadcast type.
     * @return            this request.
     */
    public UpdateRequest rebroadcast(RebroadcastType rebroadcast) {
        set("rebroadcast", rebroadcast);
        return this;
    }

}
