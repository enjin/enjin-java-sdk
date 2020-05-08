package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
import lombok.Builder;

/**
 * A data model for the Approve ENJ request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class ApproveEnjData {

    /**
     * The amount of ENJ to approve. Set this to -1 to approve the maximum amount possible.
     *
     * @param value the amount of enj to approve.
     * @return the builder.
     */
    private Integer value;

}
