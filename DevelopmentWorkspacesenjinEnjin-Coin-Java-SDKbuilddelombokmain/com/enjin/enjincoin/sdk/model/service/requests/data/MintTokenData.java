package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;

public class MintTokenData {
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("token_index")
    private String tokenIndex;
    @SerializedName("recipient_address")
    private String recipientAddress;
    @SerializedName("recipient_address_array")
    private List<String> recipientAddresses;
    @SerializedName("recipient_identity_id")
    private Integer recipientIdentityId;
    @SerializedName("recipient_identity_id_array")
    private List<Integer> recipientIdentityIds;
    private Integer value;
    @SerializedName("value_array")
    private List<Integer> values;


    public static class MintTokenDataBuilder {
        private String tokenId;
        private String tokenIndex;
        private String recipientAddress;
        private List<String> recipientAddresses;
        private Integer recipientIdentityId;
        private List<Integer> recipientIdentityIds;
        private Integer value;
        private List<Integer> values;

        public MintTokenDataBuilder recipientAddress(String... recipientAddresses) {
            this.recipientAddresses = Arrays.asList(recipientAddresses);
            return this;
        }

        public MintTokenDataBuilder recipientAddress(List<String> recipientAddresses) {
            this.recipientAddresses = recipientAddresses;
            return this;
        }

        public MintTokenDataBuilder recipientIdentityIds(Integer... recipientIdentityIds) {
            this.recipientIdentityIds = Arrays.asList(recipientIdentityIds);
            return this;
        }

        public MintTokenDataBuilder recipientIdentityIds(List<Integer> recipientIdentityIds) {
            this.recipientIdentityIds = recipientIdentityIds;
            return this;
        }

        public MintTokenDataBuilder values(Integer... values) {
            this.values = Arrays.asList(values);
            return this;
        }

        public MintTokenDataBuilder values(List<Integer> values) {
            this.values = values;
            return this;
        }

        MintTokenDataBuilder() {
        }

        public MintTokenDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public MintTokenDataBuilder tokenIndex(final String tokenIndex) {
            this.tokenIndex = tokenIndex;
            return this;
        }

        public MintTokenDataBuilder recipientAddresses(final List<String> recipientAddresses) {
            this.recipientAddresses = recipientAddresses;
            return this;
        }

        public MintTokenDataBuilder recipientIdentityId(final Integer recipientIdentityId) {
            this.recipientIdentityId = recipientIdentityId;
            return this;
        }

        public MintTokenDataBuilder value(final Integer value) {
            this.value = value;
            return this;
        }

        public MintTokenData build() {
            return new MintTokenData(tokenId, tokenIndex, recipientAddress, recipientAddresses, recipientIdentityId, recipientIdentityIds, value, values);
        }

        @Override
        public String toString() {
            return "MintTokenData.MintTokenDataBuilder(tokenId=" + this.tokenId + ", tokenIndex=" + this.tokenIndex + ", recipientAddress=" + this.recipientAddress + ", recipientAddresses=" + this.recipientAddresses + ", recipientIdentityId=" + this.recipientIdentityId + ", recipientIdentityIds=" + this.recipientIdentityIds + ", value=" + this.value + ", values=" + this.values + ")";
        }
    }

    MintTokenData(final String tokenId, final String tokenIndex, final String recipientAddress, final List<String> recipientAddresses, final Integer recipientIdentityId, final List<Integer> recipientIdentityIds, final Integer value, final List<Integer> values) {
        this.tokenId = tokenId;
        this.tokenIndex = tokenIndex;
        this.recipientAddress = recipientAddress;
        this.recipientAddresses = recipientAddresses;
        this.recipientIdentityId = recipientIdentityId;
        this.recipientIdentityIds = recipientIdentityIds;
        this.value = value;
        this.values = values;
    }

    public static MintTokenDataBuilder builder() {
        return new MintTokenDataBuilder();
    }
}
