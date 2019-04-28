package com.enjin.enjincoin.sdk.model.service.requests.data;

import lombok.Builder;

import java.util.List;

/**
 * A data model for the Advanced Send Token request type.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.requests.RequestsService
 */
@Builder
public class AdvancedSendTokenData {

    /**
     * The different transfers to perform.
     *
     * -- SETTER --
     * @param transfers the transfers.
     * @return the builder.
     */
    private List<TransferData> transfers;

    /**
     * Whether the safe variant of the transaction should be used.
     *
     * -- SETTER --
     * @param safe whether to use the safe variant or not.
     * @return the builder.
     */
    private Boolean safe;

    /**
     * The data to forward with the safe callbacks.
     *
     * -- SETTER --
     * @param data the data to forward.
     * @return the builder.
     */
    private String data;

}
