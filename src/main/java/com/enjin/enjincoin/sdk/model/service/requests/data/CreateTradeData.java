package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.util.List;

@Builder
public class CreateTradeData {

    @SerializedName("asking_tokens")
    private List<TokenValueData> askingTokens;

    @SerializedName("offering_tokens")
    private List<TokenValueData> offeringTokens;

    @SerializedName("second_party_address")
    private String secondPartyAddress;

    @SerializedName("second_party_identity_id")
    private Integer secondPartyIdentityId;

}
