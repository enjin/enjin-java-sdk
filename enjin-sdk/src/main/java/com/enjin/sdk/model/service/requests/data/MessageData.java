package com.enjin.sdk.model.service.requests.data;

import com.enjin.sdk.service.requests.RequestsService;
import lombok.Builder;

/**
 * A data model for the Message request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
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
