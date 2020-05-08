package com.enjin.sdk.models.request.data;

import java.util.List;

import com.enjin.sdk.services.request.RequestsService;
import lombok.Builder;

/**
 * A data model for the Advanced Send Token request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class AdvancedSendTokenData {

    /**
     * The different transfers to perform.
     *
     * @param transfers the transfers.
     * @return the builder.
     */
    private List<TransferData> transfers;

    /**
     * The data to forward with the safe callbacks.
     *
     * @param data the data to forward.
     * @return the builder.
     */
    private String data;

}
