package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@Builder
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
    private BigInteger recipientIdentityId;

    @SerializedName("recipient_identity_id_array")
    private List<BigInteger> recipientIdentityIds;

    private Integer value;

    @SerializedName("value_array")
    private List<Integer> values;

    public static class MintTokenDataBuilder {
        public MintTokenDataBuilder recipientAddress(String... recipientAddresses) {
            this.recipientAddresses = Arrays.asList(recipientAddresses);
            return this;
        }

        public MintTokenDataBuilder recipientAddress(List<String> recipientAddresses) {
            this.recipientAddresses = recipientAddresses;
            return this;
        }

        public MintTokenDataBuilder recipientIdentityIds(BigInteger... recipientIdentityIds) {
            this.recipientIdentityIds = Arrays.asList(recipientIdentityIds);
            return this;
        }

        public MintTokenDataBuilder recipientIdentityIds(List<BigInteger> recipientIdentityIds) {
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
    }

}
