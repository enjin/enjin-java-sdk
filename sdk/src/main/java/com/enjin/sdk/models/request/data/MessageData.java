package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
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
     * @param message the message.
     * @return the builder.
     */
    private String message;

}
