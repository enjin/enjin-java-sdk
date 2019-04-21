package com.enjin.enjincoin.sdk.model.service.identities;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class IdentityFieldInput {

    private String key;

    private String value;

    private Integer searchable;

    private Integer displayable;

    private Integer unique;

}
