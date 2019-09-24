package com.enjin.enjincoin.sdk.model.service.requests.data;

import lombok.Builder;

/**
 * A data model for the Message request type.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.requests.RequestsService
 */
@Builder
public class MessageData {

    /**
     * The message to sign.
     *
     * -- SETTER --
     *
     * @param message the message.
     * @return the builder.
     */
    private String message;

}
