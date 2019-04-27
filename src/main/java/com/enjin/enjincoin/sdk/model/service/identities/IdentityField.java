package com.enjin.enjincoin.sdk.model.service.identities;

import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

/**
 * Represents a key value pair associated with an identity.
 *
 * @author Evan Lindsay
 * @see Identity
 * @see IdentityFieldInput
 */
@ToString
@Getter
public class IdentityField {

    /**
     * The field id.
     *
     * @return the field id.
     */
    private BigInteger id;

    /**
     * The field key.
     *
     * @return the field key.
     */
    private String key;

    /**
     * The field value.
     *
     * @return the field value.
     */
    private String value;

    /**
     * Can the key be searched for.
     *
     * @return true if the key can be searched for, else false.
     */
    private Integer searchable;

    /**
     * Can the key be displayed.
     *
     * @return true if the key can be displayed, else false.
     */
    private Integer displayable;

    /**
     * Is the key unique.
     *
     * @return true if the key is unique, else false.
     */
    private Integer unique;

}
