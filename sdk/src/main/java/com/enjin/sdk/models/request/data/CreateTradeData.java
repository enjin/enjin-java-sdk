package com.enjin.sdk.models.request.data;

import java.util.List;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Create Trade request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class CreateTradeData {

    /**
     * The tokens the first party is asking for.
     *
     * @param askingTokens the tokens.
     * @return the builder.
     */
    @SerializedName("asking_tokens")
    private List<TokenValueData> askingTokens;

    /**
     * The tokens the first party is offering.
     *
     * @param offeringTokens the tokens.
     * @return the builder.
     */
    @SerializedName("offering_tokens")
    private List<TokenValueData> offeringTokens;

    /**
     * The second party Ethereum address.
     *
     * @param secondPartyAddress the Ethereum address.
     * @return the builder.
     */
    @SerializedName("second_party_address")
    private String secondPartyAddress;

    /**
     * The second party identity id.
     *
     * @param secondPartyIdentityId the identity id.
     * @return the builder.
     */
    @SerializedName("second_party_identity_id")
    private Integer secondPartyIdentityId;

}
