package com.enjin.enjincoin.sdk.model.service.identities;

import lombok.Builder;
import lombok.ToString;

/**
 * A builder for creating a new field input.
 *
 * @author Evan Lindsay
 * @see IdentityField
 * @see Identity
 */
@Builder
@ToString
public class IdentityFieldInput {

    /**
     * The field key.
     *
     * -- SETTER --
     * @param key the key
     * @return the builder.
     */
    private String key;

    /**
     * The field value.
     *
     * -- SETTER --
     * @param value the value.
     * @return the builder.
     */
    private String value;

    /**
     * Is the field searchable?
     *
     * -- SETTER --
     * @param searchable is searchable.
     * @return the builder.
     */
    private Integer searchable;

    /**
     * Is the field displayable?
     *
     * -- SETTER --
     * @param displayable is displayable.
     * @return the builder.
     */
    private Integer displayable;

    /**
     * Is the field unique?
     *
     * -- SETTER --
     * @param unique is unique
     * @return the builder.
     */
    private Integer unique;

}
