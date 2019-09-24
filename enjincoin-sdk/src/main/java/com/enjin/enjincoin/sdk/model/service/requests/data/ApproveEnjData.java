package com.enjin.enjincoin.sdk.model.service.requests.data;

import lombok.Builder;

/**
 * A data model for the Approve ENJ request type.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.requests.RequestsService
 */
@Builder
public class ApproveEnjData {

    /**
     * The amount of ENJ to approve. Set this to -1 to approve the maximum amount possible.
     *
     * -- SETTER --
     *
     * @param value the amount of enj to approve.
     * @return the builder.
     */
    private Integer value;

}
