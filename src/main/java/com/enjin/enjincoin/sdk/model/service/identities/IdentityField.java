package com.enjin.enjincoin.sdk.model.service.identities;

import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

/**
 * <p>FieldVO class.
 * </p>
 */
@ToString
@Getter
public class IdentityField {

    private BigInteger id;

    private String key;

    private String value;

    private Integer searchable;

    private Integer displayable;

    private Integer unique;

}
