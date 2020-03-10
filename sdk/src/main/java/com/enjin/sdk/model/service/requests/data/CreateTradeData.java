package com.enjin.sdk.model.service.requests.data;

import java.util.List;

import com.enjin.sdk.service.requests.RequestsService;
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
     * -- SETTER --
     *
     * @param askingTokens the tokens.
     * @return the builder.
     */
    @SerializedName("asking_tokens")
    private List<TokenValueData> askingTokens;

    /**
     * The tokens the first party is offering.
     *
     * -- SETTER --
     *
     * @param offeringTokens the tokens.
     * @return the builder.
     */
    @SerializedName("offering_tokens")
    private List<TokenValueData> offeringTokens;

    /**
     * The second party ethereum address.
     *
     * -- SETTER --
     *
     * @param secondPartyAddress the ethereum address.
     * @return the builder.
     */
    @SerializedName("second_party_address")
    private String secondPartyAddress;

    /**
     * The second party identity id.
     *
     * -- SETTER --
     *
     * @param secondPartyIdentityId the identity id.
     * @return the builder.
     */
    @SerializedName("second_party_identity_id")
    private Integer secondPartyIdentityId;

}
