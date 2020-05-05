package com.enjin.sdk.models.token.event;

import com.enjin.sdk.services.token.TokensService;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a Trusted Platform Token Event.
 *
 * @see TokensService
 */
@Getter
@ToString
public class TokenEvent {

    /**
     * -- GETTER --
     * Returns the id of the event.
     *
     * @return the event id
     */
    private Integer id;

    /**
     * -- GETTER --
     * Returns the id of the token the event belongs to.
     *
     * @return the token id
     */
    private String tokenId;

    /**
     * -- GETTER --
     * Returns the event type.
     *
     * @return the type
     */
    private TokenEventType event;

    /**
     * -- GETTER --
     * Returns the first parameter of the event.
     *
     * @return the first parameter
     */
    private String param1;

    /**
     * -- GETTER --
     * Returns the second parameter of the event.
     *
     * @return the second parameter
     */
    private String param2;

    /**
     * -- GETTER --
     * Returns the third parameter of the event.
     *
     * @return the third parameter
     */
    private String param3;

    /**
     * -- GETTER --
     * Returns the fourth parameter of the event.
     *
     * @return the fourth parameter
     */
    private String param4;

    /**
     * -- GETTER --
     * Returns the block number the event occurred.
     *
     * @return the block number
     */
    private Integer blockNumber;

}
