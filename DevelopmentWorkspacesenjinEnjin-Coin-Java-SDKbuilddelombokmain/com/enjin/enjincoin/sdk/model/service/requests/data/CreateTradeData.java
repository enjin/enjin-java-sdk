package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CreateTradeData {
    @SerializedName("asking_tokens")
    private List<TokenValueData> askingTokens;
    @SerializedName("offering_tokens")
    private List<TokenValueData> offeringTokens;
    @SerializedName("second_party_address")
    private String secondPartyAddress;
    @SerializedName("second_party_identity_id")
    private Integer secondPartyIdentityId;

    CreateTradeData(final List<TokenValueData> askingTokens, final List<TokenValueData> offeringTokens, final String secondPartyAddress, final Integer secondPartyIdentityId) {
        this.askingTokens = askingTokens;
        this.offeringTokens = offeringTokens;
        this.secondPartyAddress = secondPartyAddress;
        this.secondPartyIdentityId = secondPartyIdentityId;
    }


    public static class CreateTradeDataBuilder {
        private List<TokenValueData> askingTokens;
        private List<TokenValueData> offeringTokens;
        private String secondPartyAddress;
        private Integer secondPartyIdentityId;

        CreateTradeDataBuilder() {
        }

        public CreateTradeDataBuilder askingTokens(final List<TokenValueData> askingTokens) {
            this.askingTokens = askingTokens;
            return this;
        }

        public CreateTradeDataBuilder offeringTokens(final List<TokenValueData> offeringTokens) {
            this.offeringTokens = offeringTokens;
            return this;
        }

        public CreateTradeDataBuilder secondPartyAddress(final String secondPartyAddress) {
            this.secondPartyAddress = secondPartyAddress;
            return this;
        }

        public CreateTradeDataBuilder secondPartyIdentityId(final Integer secondPartyIdentityId) {
            this.secondPartyIdentityId = secondPartyIdentityId;
            return this;
        }

        public CreateTradeData build() {
            return new CreateTradeData(askingTokens, offeringTokens, secondPartyAddress, secondPartyIdentityId);
        }

        @Override
        public String toString() {
            return "CreateTradeData.CreateTradeDataBuilder(askingTokens=" + this.askingTokens + ", offeringTokens=" + this.offeringTokens + ", secondPartyAddress=" + this.secondPartyAddress + ", secondPartyIdentityId=" + this.secondPartyIdentityId + ")";
        }
    }

    public static CreateTradeDataBuilder builder() {
        return new CreateTradeDataBuilder();
    }
}
