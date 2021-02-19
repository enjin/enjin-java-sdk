package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;

/**
 * Models input for the transfer fee settings used in GraphQL requests.
 *
 * @see com.enjin.sdk.schemas.project.mutations.CreateToken
 */
@EqualsAndHashCode
public class TokenTransferFeeSettingsInput {

    private TokenTransferFeeType type;
    private String tokenId;
    private String value;

    /**
     * Sets the transfer type for this input.
     *
     * @param type the type
     * @return this request for chaining
     */
    public TokenTransferFeeSettingsInput type(TokenTransferFeeType type) {
        this.type = type;
        return this;
    }

    /**
     * Sets the token ID for this input.
     *
     * @param tokenId the ID
     * @return this request for chaining
     */
    public TokenTransferFeeSettingsInput tokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    /**
     * Sets the value in Wei for this input.
     *
     * @param value the value
     * @return this request for chaining
     */
    public TokenTransferFeeSettingsInput value(String value) {
        this.value = value;
        return this;
    }

}
